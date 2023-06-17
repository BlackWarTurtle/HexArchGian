package hex.arch.gian.infraestructure.rest.adapters.users;

import hex.arch.gian.domain.models.users.DomainUser;
import hex.arch.gian.domain.models.users.userData.CreateUserData;
import hex.arch.gian.domain.models.users.userData.UpdateUserData;
import hex.arch.gian.domain.models.users.userData.UserData;
import hex.arch.gian.domain.ports.primaries.UserService;
import hex.arch.gian.infraestructure.rest.models.users.createuser.CreateUserRequest;
import hex.arch.gian.infraestructure.rest.models.users.createuser.CreateUserResponse;
import hex.arch.gian.infraestructure.rest.models.users.createuser.UpdateUserRequest;
import hex.arch.gian.infraestructure.rest.models.users.createuser.UpdateUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserAdapter {

  private final UserService userService;

  public List<DomainUser> getAllUsers() {
    return userService.getAllUsers();
  }

  public DomainUser getUserById(final long codUser) {
    return userService.getUserById(codUser);
  }

  public CreateUserResponse createUser(final CreateUserRequest createUserRequest) {
    CreateUserData userData =
        CreateUserData.builder()
            .codUser(createUserRequest.getCodUser())
            .txtName(createUserRequest.getTxtName())
            .txtSurname(createUserRequest.getTxtSurname())
            .build();

    DomainUser createdUser = userService.createUser(userData);

    return CreateUserResponse.builder()
        .codUser(createdUser.getCodUser())
        .txtName(createdUser.getTxtName())
        .txtSurname(createdUser.getTxtSurname())
        .build();
  }

  public UpdateUserResponse updateUser(final UpdateUserRequest updateUserRequest) {
    UpdateUserData updateUserData =
        UpdateUserData.builder()
            .codUser(updateUserRequest.getCodUser())
            .txtName(updateUserRequest.getTxtName())
            .txtSurname(updateUserRequest.getTxtSurname())
            .build();

    DomainUser updateUser = userService.updateUser(updateUserData);

    return UpdateUserResponse.builder()
        .codUser(updateUser.getCodUser())
        .txtName(updateUser.getTxtName())
        .txtSurname(updateUser.getTxtSurname())
        .build();
  }

  public void deleteUserById(final long codUser) {
    userService.deleteUserById(codUser);
  }
}
