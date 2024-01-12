package hex.arch.gian.domain.ports.secondaries.tokens;

import hex.arch.gian.domain.models.tokens.DomainToken;

import java.util.List;

public interface TokenPort {

  DomainToken getToken(String tokenId);

  List<DomainToken> getTokens(List<String> tokenIds);
}
