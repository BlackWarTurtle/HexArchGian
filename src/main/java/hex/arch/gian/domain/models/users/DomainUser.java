package hex.arch.gian.domain.models.users;


import hex.arch.gian.domain.models.enums.UserTypeEnum;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@SuperBuilder(toBuilder = true)
public abstract class DomainUser implements Serializable {
    private String name;
    private String surname;
    private UserTypeEnum userType;
    private LocalDateTime birthDate;
}
