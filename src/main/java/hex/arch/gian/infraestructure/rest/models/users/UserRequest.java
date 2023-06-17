package hex.arch.gian.infraestructure.rest.models.users;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
public abstract class UserRequest {
    long codUser;
    String txtName;
    String txtSurname;
}
