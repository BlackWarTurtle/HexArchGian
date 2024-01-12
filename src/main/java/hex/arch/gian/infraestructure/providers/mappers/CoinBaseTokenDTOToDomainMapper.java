package hex.arch.gian.infraestructure.providers.mappers;

import hex.arch.gian.domain.models.tokens.DomainToken;
import hex.arch.gian.infraestructure.providers.models.CoinBaseTokenDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CoinBaseTokenDTOToDomainMapper implements Function<CoinBaseTokenDTO, DomainToken> {

  @Override
  public DomainToken apply(CoinBaseTokenDTO coinBaseTokenDTO) {
    return DomainToken.builder()
        .name(coinBaseTokenDTO.getName())
        .price(coinBaseTokenDTO.getPrice())
        .currency(coinBaseTokenDTO.getCurrency())
        .build();
  }
}
