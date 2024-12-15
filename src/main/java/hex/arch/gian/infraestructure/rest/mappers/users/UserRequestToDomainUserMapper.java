package hex.arch.gian.infraestructure.rest.mappers.users;

import hex.arch.gian.config.security.services.EncodingService;
import hex.arch.gian.domain.models.users.DomainUser;
import hex.arch.gian.infraestructure.rest.models.users.UserRequest;
import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component
public class UserRequestToDomainUserMapper implements Function<UserRequest, DomainUser> {
  private final EncodingService encodingService;

  public UserRequestToDomainUserMapper(EncodingService encodingService) {
    this.encodingService = encodingService;
  }

  @Override
  public DomainUser apply(UserRequest userRequest) {
    return DomainUser.builder()
        .name(userRequest.getUserDTO().getName())
        .surname(userRequest.getUserDTO().getSurname())
        .userType(userRequest.getUserDTO().getUserType())
        .birthDate(userRequest.getUserDTO().getBirthDate())
        .password(encodingService.applyHash(userRequest.getUserDTO().getPassword()))
        .build();
  }
}
