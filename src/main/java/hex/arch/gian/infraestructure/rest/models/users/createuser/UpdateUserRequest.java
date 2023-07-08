package hex.arch.gian.infraestructure.rest.models.users.createuser;

import hex.arch.gian.infraestructure.rest.models.users.UserRequest;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class UpdateUserRequest extends UserRequest {}
