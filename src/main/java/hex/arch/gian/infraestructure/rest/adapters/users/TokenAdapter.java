package hex.arch.gian.infraestructure.rest.adapters.users;

import hex.arch.gian.domain.models.tokens.DomainToken;
import hex.arch.gian.domain.ports.primaries.tokens.TokenService;
import hex.arch.gian.infraestructure.rest.mappers.tokens.TokenDTOMapper;
import hex.arch.gian.infraestructure.rest.models.tokens.TokenDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TokenAdapter {

  private final TokenService tokenService;

  private final TokenDTOMapper tokenDTOMapper;

  public TokenDTO getToken(String tokenId) {
    DomainToken domainToken = tokenService.getToken(tokenId);

    return tokenDTOMapper.apply(domainToken);
  }

  public List<TokenDTO> getTokens(List<String> tokenIds) {
    return tokenService.getTokens(tokenIds).stream().map(tokenDTOMapper).toList();
  }
}
