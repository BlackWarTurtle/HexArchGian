package hex.arch.gian.infraestructure.rest.models.users;

import lombok.Data;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
public abstract class UserResponse {
    private long codUser;
    private String txtName;
    private String txtSurname;
}
