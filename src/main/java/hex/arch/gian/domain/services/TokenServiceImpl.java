package hex.arch.gian.domain.services;

import hex.arch.gian.domain.models.tokens.DomainToken;
import hex.arch.gian.domain.ports.primaries.tokens.TokenService;
import hex.arch.gian.domain.ports.secondaries.tokens.TokenPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TokenServiceImpl implements TokenService {

  private final TokenPort tokenPort;

  @Override
  public DomainToken getToken(String tokenId) {
    return tokenPort.getToken(tokenId);
  }

  @Override
  public List<DomainToken> getTokens(List<String> tokenIds) {
    return tokenPort.getTokens(tokenIds);
  }
}
