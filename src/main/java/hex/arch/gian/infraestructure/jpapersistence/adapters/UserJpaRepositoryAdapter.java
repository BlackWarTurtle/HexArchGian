package hex.arch.gian.infraestructure.jpapersistence.adapters;

import hex.arch.gian.domain.models.users.DomainUser;
import hex.arch.gian.domain.ports.secondaries.users.UserPort;
import hex.arch.gian.infraestructure.jpapersistence.mappers.UserMapper;
import hex.arch.gian.infraestructure.jpapersistence.mappers.UserToDomainMapper;
import hex.arch.gian.infraestructure.jpapersistence.models.users.User;
import hex.arch.gian.infraestructure.jpapersistence.repositories.UsersJpaRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@ConditionalOnProperty(prefix = "datasource", name = "engine", havingValue = "mysql")
public class UserJpaRepositoryAdapter implements UserPort {

  private final UsersJpaRepository usersJpaRepository;

  private final UserMapper userMapper;
  private final UserToDomainMapper userToDomainMapper;

  @Override
  public List<DomainUser> getAllUsers() {
    return usersJpaRepository.findAll().stream().map(userToDomainMapper).toList();
  }

  @Override
  public Optional<DomainUser> getUserById(long codUser) {
    return usersJpaRepository.findById(codUser).map(userToDomainMapper);
  }

  @Override
  public DomainUser createUser(final DomainUser domainUser) {
    User user = userMapper.apply(domainUser);

    User savedUser = usersJpaRepository.saveAndFlush(user);

    return userToDomainMapper.apply(savedUser);
  }

  @Override
  public DomainUser updateUser(final DomainUser domainUser) {
    User user = userMapper.apply(domainUser);

    User updatedUser = usersJpaRepository.saveAndFlush(user);

    return userToDomainMapper.apply(updatedUser);
  }

  @Override
  public void deleteUserById(final long codUser) {
    usersJpaRepository.deleteById(codUser);
  }

  @Override
  public boolean existsById(final long codUser) {
    return usersJpaRepository.existsById(codUser);
  }
}
