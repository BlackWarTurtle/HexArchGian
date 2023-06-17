package hex.arch.gian.infraestructure.rest.models.users.createuser;

import hex.arch.gian.infraestructure.rest.models.users.UserRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder(toBuilder = false)
public class CreateUserRequest extends UserRequest {}
