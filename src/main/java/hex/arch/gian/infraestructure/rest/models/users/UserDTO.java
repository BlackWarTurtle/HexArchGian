package hex.arch.gian.infraestructure.rest.models.users;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDTO {
  Long codUser;
  @NotEmpty String txtName;
  @NotEmpty String txtSurname;
  @NotNull Integer indType;
}
