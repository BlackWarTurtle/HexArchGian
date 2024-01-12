package hex.arch.gian.infraestructure.rest.mappers.users;

import hex.arch.gian.domain.models.users.DomainUser;
import hex.arch.gian.infraestructure.rest.models.users.UserRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserRequestToDomainUserMapper implements Function<UserRequest, DomainUser> {

  @Override
  public DomainUser apply(UserRequest userRequest) {
    return DomainUser.builder()
        .id(userRequest.getUserDTO().getId())
        .name(userRequest.getUserDTO().getName())
        .surname(userRequest.getUserDTO().getSurname())
        .userType(userRequest.getUserDTO().getUserType())
        .birthDate(userRequest.getUserDTO().getBirthDate())
        .build();
  }
}
