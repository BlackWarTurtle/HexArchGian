package hex.arch.gian.infraestructure.rest.adapters.users;

import hex.arch.gian.domain.models.users.DomainUser;
import hex.arch.gian.domain.ports.primaries.users.UserService;
import hex.arch.gian.infraestructure.rest.mappers.users.DomainUserMapper;
import hex.arch.gian.infraestructure.rest.mappers.users.UserRequestToDomainUserMapper;
import hex.arch.gian.infraestructure.rest.models.users.UserDTO;
import hex.arch.gian.infraestructure.rest.models.users.createuser.CreateUserRequest;
import hex.arch.gian.infraestructure.rest.models.users.createuser.CreateUserResponse;
import hex.arch.gian.infraestructure.rest.models.users.updateuser.UpdateUserRequest;
import hex.arch.gian.infraestructure.rest.models.users.updateuser.UpdateUserResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAdapter {

  private final UserService userService;
  private final DomainUserMapper domainUserMapper;
  private final UserRequestToDomainUserMapper userRequestToDomainUserMapper;

  public List<UserDTO> getAllUsers() {
    return userService.getAllUsers().stream().map(domainUserMapper).toList();
  }

  public UserDTO getUserById(final long codUser) {
    DomainUser user = userService.getUserById(codUser);
    return domainUserMapper.apply(user);
  }

  public CreateUserResponse createUser(final CreateUserRequest createUserRequest) {

    DomainUser createdUser =
        userService.createUser(userRequestToDomainUserMapper.apply(createUserRequest));

    return CreateUserResponse.builder().userDTO(domainUserMapper.apply(createdUser)).build();
  }

  public UpdateUserResponse updateUser(
      final long codUser, final UpdateUserRequest updateUserRequest) {

    DomainUser updatedUser =
        userService.updateUser(codUser, userRequestToDomainUserMapper.apply(updateUserRequest));

    return UpdateUserResponse.builder().userDTO(domainUserMapper.apply(updatedUser)).build();
  }

  public void deleteUserById(final long codUser) {
    userService.deleteUserById(codUser);
  }

  public void createGraph() {
    userService.createGraph();
  }
}
