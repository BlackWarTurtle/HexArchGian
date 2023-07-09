package hex.arch.gian.infraestructure.jpapersistence.adapters;

import hex.arch.gian.domain.models.users.DomainUser;
import hex.arch.gian.domain.ports.secondaries.UserPort;
import hex.arch.gian.infraestructure.jpapersistence.models.users.User;
import hex.arch.gian.infraestructure.jpapersistence.repositories.UsersJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserJpaRepositoryAdapter implements UserPort {

  private final UsersJpaRepository usersJpaRepository;

  @Override
  public List<DomainUser> getAllUsers() {
    return usersJpaRepository.findAll().stream()
        .map(this::buildDomainUser)
        .collect(Collectors.toList());
  }

  @Override
  public Optional<DomainUser> getUserById(long codUser) {
    return usersJpaRepository.findById(codUser).map(this::buildDomainUser);
  }

  @Override
  public DomainUser createUser(final DomainUser domainUser) {
    User user = buildUser(domainUser);

    User savedUser = usersJpaRepository.saveAndFlush(user);

    return buildDomainUser(savedUser);
  }

  @Override
  public DomainUser updateUser(final DomainUser domainUser) {
    User user = buildUser(domainUser);

    User updatedUser = usersJpaRepository.saveAndFlush(user);

    return buildDomainUser(updatedUser);
  }

  @Override
  public void deleteUserById(final long codUser) {
    usersJpaRepository.deleteById(codUser);
  }

  @Override
  public boolean existsById(final long codUser) {
    return usersJpaRepository.existsById(codUser);
  }

  private DomainUser buildDomainUser(final User user) {
    return DomainUser.builder()
        .codUser(user.getCodUser())
        .txtName(user.getTxtName())
        .txtSurname(user.getTxtSurname())
        .userType(user.getUserType())
        .build();
  }

  private User buildUser(final DomainUser domainUser) {
    var userBuilder = User.builder();

    if (!ObjectUtils.isEmpty(domainUser.getCodUser())) {
      userBuilder.codUser(domainUser.getCodUser());
    }

    userBuilder.txtName(domainUser.getTxtName());
    userBuilder.txtSurname(domainUser.getTxtSurname());
    userBuilder.userType(domainUser.getUserType());

    return userBuilder.build();
  }
}
