package hex.arch.gian.infraestructure.rest.controllers.users;

import hex.arch.gian.infraestructure.rest.adapters.users.UserAdapter;
import hex.arch.gian.infraestructure.rest.models.users.UserDTO;
import hex.arch.gian.infraestructure.rest.models.users.createuser.CreateUserRequest;
import hex.arch.gian.infraestructure.rest.models.users.createuser.CreateUserResponse;
import hex.arch.gian.infraestructure.rest.models.users.createuser.UpdateUserRequest;
import hex.arch.gian.infraestructure.rest.models.users.createuser.UpdateUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

  private final UserAdapter userAdapter;

  @GetMapping
  public ResponseEntity<List<UserDTO>> getAllUsers() {
    return new ResponseEntity<>(userAdapter.getAllUsers(), HttpStatus.OK);
  }

  @GetMapping("/{codUser}")
  public ResponseEntity<UserDTO> getUserById(@PathVariable final long codUser) {
    return new ResponseEntity<>(userAdapter.getUserById(codUser), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<CreateUserResponse> createUser(
      @RequestBody CreateUserRequest createUserRequest) {

    return new ResponseEntity<>(userAdapter.createUser(createUserRequest), HttpStatus.CREATED);
  }

  @PutMapping("/{codUser}")
  public ResponseEntity<UpdateUserResponse> updateUser(
      @PathVariable final long codUser, @RequestBody UpdateUserRequest updateUserRequest) {
    return new ResponseEntity<>(userAdapter.updateUser(codUser, updateUserRequest), HttpStatus.OK);
  }

  @DeleteMapping("/{codUser}")
  public ResponseEntity<Void> deleteUserById(@PathVariable final long codUser) {
    userAdapter.deleteUserById(codUser);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
