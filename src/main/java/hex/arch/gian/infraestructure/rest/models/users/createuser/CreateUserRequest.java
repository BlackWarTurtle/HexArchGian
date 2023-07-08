package hex.arch.gian.infraestructure.rest.models.users.createuser;

import hex.arch.gian.infraestructure.rest.models.users.UserRequest;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@SuperBuilder()
public class CreateUserRequest extends UserRequest {}
