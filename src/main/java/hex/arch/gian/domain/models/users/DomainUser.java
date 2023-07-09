package hex.arch.gian.domain.models.users;


import hex.arch.gian.domain.models.enums.UserTypeEnum;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class DomainUser implements Serializable {
    private Long codUser;
    private String txtName;
    private String txtSurname;
    private UserTypeEnum userType;
}
