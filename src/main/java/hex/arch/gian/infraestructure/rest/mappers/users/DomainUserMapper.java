package hex.arch.gian.infraestructure.rest.mappers.users;

import hex.arch.gian.domain.models.users.DomainUser;
import hex.arch.gian.infraestructure.rest.models.users.UserDTO;
import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component
public class DomainUserMapper implements Function<DomainUser, UserDTO> {

  @Override
  public UserDTO apply(DomainUser domainUser) {
    return UserDTO.builder()
        .id(domainUser.getId())
        .name(domainUser.getName())
        .surname(domainUser.getSurname())
        .userType(domainUser.getUserType())
        .birthDate(domainUser.getBirthDate())
        .password(domainUser.getPassword())
        .build();
  }
}
