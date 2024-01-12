package hex.arch.gian.infraestructure.providers.providers.coinbase;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hex.arch.gian.config.exceptions.ValidationException;
import hex.arch.gian.infraestructure.providers.models.CoinBaseTokenDTO;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TokenCoinBaseProviderImpl implements TokenCoinBaseProvider {

  private static final String COIN_BASE_URL_BASE = "https://api.coinbase.com";

  private final ObjectMapper objectMapper;

  private final HttpClient httpClient;

  @Override
  public CoinBaseTokenDTO getTokenFromCoinBase(String tokenId) {
    CoinBaseTokenDTO result;

    try {
      HttpResponse<String> response =
          httpClient.send(buildTokenHttpRequest(tokenId), HttpResponse.BodyHandlers.ofString());

      result = processResult(response.body());

    } catch (IOException | InterruptedException e) {
      throw new RuntimeException(e);
    }

    return result;
  }

  @Override
  public List<CoinBaseTokenDTO> getTokensFromCoinBase(List<String> tokenIds) {
    /*URI Targets*/
    List<URI> targetList = tokenIds.stream().map(this::buildTargetURI).toList();

    CompletableFuture<List<String>> allFutureResponses = performRequestsToCoinBase(targetList);

    /*Process the results once all futures are completed*/
    return allFutureResponses
        .thenApply(resultList -> resultList.stream().map(this::processResult).toList())
        .join();
  }

  private CompletableFuture<List<String>> performRequestsToCoinBase(List<URI> targetList) {
    List<CompletableFuture<String>> futures =
        targetList.stream()
            .map(
                target ->
                    httpClient
                        .sendAsync(
                            HttpRequest.newBuilder(target).GET().build(),
                            HttpResponse.BodyHandlers.ofString())
                        .thenApply(HttpResponse::body))
            .toList();

    CompletableFuture<Void> allOf =
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

    /*Wait for all futures to complete*/
    return allOf.thenApply(v -> futures.stream().map(CompletableFuture::join).toList());
  }

  private CoinBaseTokenDTO processResult(String result) {
    try {
      return objectMapper.readValue(result, CoinBaseTokenDTO.class);
    } catch (JsonProcessingException e) {
      throw new ValidationException(
          HttpStatus.INTERNAL_SERVER_ERROR, "Error parsing response from coinbase");
    }
  }

  private HttpRequest buildTokenHttpRequest(String tokenId) {
    return HttpRequest.newBuilder().uri(buildTargetURI(tokenId)).GET().build();
  }

  private URI buildTargetURI(String tokenId) {
    try {
      return new URI(String.format(COIN_BASE_URL_BASE + "/v2/prices/%s/buy", tokenId));
    } catch (URISyntaxException e) {
      throw new RuntimeException(e);
    }
  }
}
