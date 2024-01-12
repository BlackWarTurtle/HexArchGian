package hex.arch.gian.infraestructure.jpapersistence.mappers;

import hex.arch.gian.domain.models.users.DomainUser;
import hex.arch.gian.infraestructure.jpapersistence.models.users.User;
import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component
public class UserToDomainMapper implements Function<User, DomainUser> {

  @Override
  public DomainUser apply(User user) {
    return DomainUser.builder()
        .id(user.getId())
        .name(user.getName())
        .surname(user.getSurname())
        .userType(user.getUserType())
        .birthDate(user.getBirthDate())
        .build();
  }
}
