package hex.arch.gian.infraestructure.rest.models.users;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDTO {
    Long codUser;
    String txtName;
    String txtSurname;
}
