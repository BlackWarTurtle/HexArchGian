package hex.arch.gian.infraestructure.jpapersistence.mappers;

import hex.arch.gian.domain.models.users.DomainUser;
import hex.arch.gian.infraestructure.jpapersistence.models.users.User;
import java.util.function.Function;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class UserMapper implements Function<DomainUser, User> {

  @Override
  public User apply(DomainUser domainUser) {
    var userBuilder = User.builder();

    if (!ObjectUtils.isEmpty(domainUser.getId())) {
      userBuilder.id(domainUser.getId());
    }

    return userBuilder
        .name(domainUser.getName())
        .surname(domainUser.getSurname())
        .userType(domainUser.getUserType())
        .birthDate(domainUser.getBirthDate())
        .build();
  }
}
