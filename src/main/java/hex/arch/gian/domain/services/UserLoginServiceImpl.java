package hex.arch.gian.domain.services;

import hex.arch.gian.config.security.services.AuthenticationService;
import hex.arch.gian.domain.models.users.DomainUser;
import hex.arch.gian.domain.ports.primaries.login.users.UserLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLoginServiceImpl implements UserLoginService {

  private final AuthenticationService authenticationService;

  @Override
  public String authenticate(DomainUser domainUser) {
    return authenticationService.authenticateUser(domainUser);
  }
}
