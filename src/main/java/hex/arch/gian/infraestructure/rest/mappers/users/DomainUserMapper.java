package hex.arch.gian.infraestructure.rest.mappers.users;

import hex.arch.gian.domain.models.users.DomainUser;
import hex.arch.gian.domain.models.users.JpaDomainUser;
import hex.arch.gian.domain.models.users.MongoDomainUser;
import hex.arch.gian.infraestructure.rest.models.users.UserDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class DomainUserMapper implements Function<DomainUser, UserDTO> {

  @Override
  public UserDTO apply(DomainUser domainUser) {
    var userDTOBuilder = UserDTO.builder();

    if (domainUser instanceof JpaDomainUser jpaDomainUser) {
      userDTOBuilder.id(jpaDomainUser.getId());
    } else if (domainUser instanceof MongoDomainUser mongoDomainUser) {
      userDTOBuilder.externalId(mongoDomainUser.getExternalId());
    }

    return UserDTO.builder()
        .name(domainUser.getName())
        .surname(domainUser.getSurname())
        .userType(domainUser.getUserType())
        .birthDate(domainUser.getBirthDate())
        .build();
  }
}
