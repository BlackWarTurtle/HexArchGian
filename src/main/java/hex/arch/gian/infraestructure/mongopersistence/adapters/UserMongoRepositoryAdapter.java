package hex.arch.gian.infraestructure.mongopersistence.adapters;

import hex.arch.gian.annotations.mongo.MongoComponent;
import hex.arch.gian.domain.models.users.DomainUser;
import hex.arch.gian.domain.models.users.MongoDomainUser;
import hex.arch.gian.domain.ports.secondaries.users.UserPort;
import hex.arch.gian.infraestructure.mongopersistence.models.User;
import hex.arch.gian.infraestructure.mongopersistence.repositories.UserMongoRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@MongoComponent
public class UserMongoRepositoryAdapter implements UserPort {

  private final UserMongoRepository userMongoRepository;

  @Override
  public List<DomainUser> getAllUsers() {
    List<User> users = userMongoRepository.findAll();

    return users.stream().map(this::buildDomainUser).toList();
  }

  @Override
  public Optional<DomainUser> getUserById(long codUser) {
    return Optional.empty();
  }

  @Override
  public DomainUser createUser(DomainUser domainUser) {
    User userToBeSaved = buildUser((MongoDomainUser) domainUser);

    User savedUser = userMongoRepository.save(userToBeSaved);

    return buildDomainUser(savedUser);
  }

  @Override
  public DomainUser updateUser(DomainUser domainUser) {
    return null;
  }

  @Override
  public void deleteUserById(long codUser) {}

  @Override
  public boolean existsById(long codUser) {
    return false;
  }

  private DomainUser buildDomainUser(User user) {
    return MongoDomainUser.builder()
        .externalId(user.getId())
        .name(user.getName())
        .surname(user.getSurname())
        .build();
  }

  private User buildUser(MongoDomainUser domainUser) {
    return User.builder()
        .id(domainUser.getExternalId())
        .name(domainUser.getName())
        .surname(domainUser.getSurname())
        .build();
  }
}
