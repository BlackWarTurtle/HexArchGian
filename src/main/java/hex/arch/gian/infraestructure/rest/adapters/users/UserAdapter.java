package hex.arch.gian.infraestructure.rest.adapters.users;

import hex.arch.gian.domain.models.enums.UserTypeEnum;
import hex.arch.gian.domain.models.users.DomainUser;
import hex.arch.gian.domain.ports.primaries.UserService;
import hex.arch.gian.infraestructure.rest.models.users.UserDTO;
import hex.arch.gian.infraestructure.rest.models.users.UserRequest;
import hex.arch.gian.infraestructure.rest.models.users.createuser.CreateUserRequest;
import hex.arch.gian.infraestructure.rest.models.users.createuser.CreateUserResponse;
import hex.arch.gian.infraestructure.rest.models.users.updateuser.UpdateUserRequest;
import hex.arch.gian.infraestructure.rest.models.users.updateuser.UpdateUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserAdapter {

  private final UserService userService;

  public List<UserDTO> getAllUsers() {
    return userService.getAllUsers().stream().map(this::buildUserDTO).collect(Collectors.toList());
  }

  public void createGraph() {
    userService.createGraph();
  }

  public UserDTO getUserById(final long codUser) {
    DomainUser user = userService.getUserById(codUser);
    return buildUserDTO(user);
  }

  public CreateUserResponse createUser(final CreateUserRequest createUserRequest) {

    DomainUser createdUser = userService.createUser(buildDomainUserFromRequest(createUserRequest));

    return CreateUserResponse.builder().userDTO(buildUserDTO(createdUser)).build();
  }

  public UpdateUserResponse updateUser(
      final long codUser, final UpdateUserRequest updateUserRequest) {

    DomainUser updateUser =
        userService.updateUser(codUser, buildDomainUserFromRequest(updateUserRequest));

    return UpdateUserResponse.builder().userDTO(buildUserDTO(updateUser)).build();
  }

  public void deleteUserById(final long codUser) {
    userService.deleteUserById(codUser);
  }

  private UserDTO buildUserDTO(final DomainUser domainUser) {
    return UserDTO.builder()
        .codUser(domainUser.getCodUser())
        .txtName(domainUser.getTxtName())
        .txtSurname(domainUser.getTxtSurname())
        .indType(domainUser.getUserType().getCode())
        .build();
  }

  private DomainUser buildDomainUserFromRequest(final UserRequest userRequest) {
    return DomainUser.builder()
        .codUser(userRequest.getUserDTO().getCodUser())
        .txtName(userRequest.getUserDTO().getTxtName())
        .txtSurname(userRequest.getUserDTO().getTxtSurname())
        .userType(UserTypeEnum.fromCode(userRequest.getUserDTO().getIndType()))
        .build();
  }
}
