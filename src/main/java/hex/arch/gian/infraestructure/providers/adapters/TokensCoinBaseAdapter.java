package hex.arch.gian.infraestructure.providers.adapters;

import hex.arch.gian.domain.models.tokens.DomainToken;
import hex.arch.gian.domain.ports.secondaries.tokens.TokenPort;
import hex.arch.gian.infraestructure.providers.mappers.CoinBaseTokenDTOToDomainMapper;
import hex.arch.gian.infraestructure.providers.models.CoinBaseTokenDTO;
import hex.arch.gian.infraestructure.providers.providers.coinbase.TokenCoinBaseProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TokensCoinBaseAdapter implements TokenPort {

  private final TokenCoinBaseProvider tokenCoinBaseService;

  private final CoinBaseTokenDTOToDomainMapper coinBaseTokenDTOToDomainMapper;

  @Override
  public DomainToken getToken(String tokenId) {
    CoinBaseTokenDTO coinBaseTokenDTO = tokenCoinBaseService.getTokenFromCoinBase(tokenId);

    DomainToken domainToken = coinBaseTokenDTOToDomainMapper.apply(coinBaseTokenDTO);
    domainToken.setId(tokenId);

    return domainToken;
  }

  @Override
  public List<DomainToken> getTokens(List<String> tokenIds) {

    List<CoinBaseTokenDTO> tokensFromCoinBase =
        tokenCoinBaseService.getTokensFromCoinBase(tokenIds);

    return tokensFromCoinBase.stream().map(coinBaseTokenDTOToDomainMapper).toList();
  }
}
