package hex.arch.gian.domain.models.users;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class DomainUser implements Serializable {
    private long codUser;
    private String txtName;
    private String txtSurname;
}
