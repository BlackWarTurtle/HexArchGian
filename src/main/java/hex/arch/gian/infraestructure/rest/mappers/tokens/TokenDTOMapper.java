package hex.arch.gian.infraestructure.rest.mappers.tokens;

import hex.arch.gian.domain.models.tokens.DomainToken;
import hex.arch.gian.infraestructure.rest.models.tokens.TokenDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TokenDTOMapper implements Function<DomainToken, TokenDTO> {

  @Override
  public TokenDTO apply(DomainToken domainToken) {
    return TokenDTO.builder()
        .id(domainToken.getId())
        .name(domainToken.getName())
        .price(domainToken.getPrice())
        .currency(domainToken.getCurrency())
        .build();
  }
}
