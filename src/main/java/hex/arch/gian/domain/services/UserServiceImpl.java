package hex.arch.gian.domain.services;

import hex.arch.gian.config.exceptions.ValidationException;
import hex.arch.gian.domain.models.users.DomainUser;
import hex.arch.gian.domain.ports.primaries.UserService;
import hex.arch.gian.domain.ports.secondaries.UserPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

  private static final String USER_NOT_FOUND_EXCEPTION_MSG = "User Not Found";

  private final UserPort userPort;

  @Override
  public List<DomainUser> getAllUsers() {
    return userPort.getAllUsers();
  }

  @Override
  public DomainUser getUserById(final long codUser) {
    return userPort.getUserById(codUser).orElseThrow(this::buildExceptionWhenNotFoundUser);
  }

  @Override
  public DomainUser createUser(final DomainUser domainUser) {
    return userPort.createUser(domainUser);
  }

  @Override
  public DomainUser updateUser(final long codUser, final DomainUser domainUser) {
    if (!userPort.existsById(codUser)) {
      throw buildExceptionWhenNotFoundUser();
    }

    return userPort.updateUser(domainUser);
  }

  @Override
  public void deleteUserById(final long codUser) {
    if (!userPort.existsById(codUser)) {
      throw buildExceptionWhenNotFoundUser();
    }

    userPort.deleteUserById(codUser);
  }

  private ValidationException buildExceptionWhenNotFoundUser() {
    return new ValidationException(HttpStatus.NOT_FOUND, USER_NOT_FOUND_EXCEPTION_MSG);
  }
}
