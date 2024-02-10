package hex.arch.gian.domain.models.users;


import hex.arch.gian.domain.models.enums.UserTypeEnum;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
public class DomainUser implements Serializable {
    private Long id;
    private String name;
    private String surname;
    private UserTypeEnum userType;
    private LocalDateTime birthDate;

    private String externalId;
}
