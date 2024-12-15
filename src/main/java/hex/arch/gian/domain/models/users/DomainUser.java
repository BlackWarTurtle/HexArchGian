package hex.arch.gian.domain.models.users;

import hex.arch.gian.domain.models.enums.UserTypeEnum;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
public class DomainUser implements Serializable {
  private String id;
  private String name;
  private String surname;
  private UserTypeEnum userType;
  private LocalDateTime birthDate;
  private String password;
}
