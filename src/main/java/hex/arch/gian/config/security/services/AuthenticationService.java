package hex.arch.gian.config.security.services;

import hex.arch.gian.domain.models.users.DomainUser;

public interface AuthenticationService {

    String authenticateUser(DomainUser domainUser);
}
