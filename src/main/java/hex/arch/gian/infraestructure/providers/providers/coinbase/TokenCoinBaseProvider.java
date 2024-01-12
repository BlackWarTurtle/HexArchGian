package hex.arch.gian.infraestructure.providers.providers.coinbase;

import hex.arch.gian.infraestructure.providers.models.CoinBaseTokenDTO;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface TokenCoinBaseProvider {

  CoinBaseTokenDTO getTokenFromCoinBase(String tokenId);

  List<CoinBaseTokenDTO> getTokensFromCoinBase(List<String> tokenIds);
}
