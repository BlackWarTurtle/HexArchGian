package hex.arch.gian.infraestructure.rest.models.users;

import hex.arch.gian.domain.models.enums.UserTypeEnum;
import hex.arch.gian.infraestructure.rest.validators.groups.FirstOrder;
import hex.arch.gian.infraestructure.rest.validators.groups.SecondOrder;
import hex.arch.gian.infraestructure.rest.validators.users.Adult;
import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@GroupSequence({UserDTO.class, FirstOrder.class, SecondOrder.class})
public class UserDTO {
  private Long id;
  @NotEmpty private String name;
  @NotEmpty private String surname;
  @NotNull private UserTypeEnum userType;

  /*Testing combining validation order*/
  @NotNull(groups = FirstOrder.class)
  @Adult(groups = SecondOrder.class)
  private LocalDateTime birthDate;
}
