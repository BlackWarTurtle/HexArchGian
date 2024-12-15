package hex.arch.gian.domain.ports.primaries.login.users;

import hex.arch.gian.domain.models.users.DomainUser;

public interface UserLoginService {
  String authenticate(DomainUser domainUser);
}
