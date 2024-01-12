package hex.arch.gian.domain.ports.primaries.tokens;

import hex.arch.gian.domain.models.tokens.DomainToken;

import java.util.List;

public interface TokenService {

    DomainToken getToken(String tokenId);

    List<DomainToken> getTokens(List<String> tokenIds);
}
