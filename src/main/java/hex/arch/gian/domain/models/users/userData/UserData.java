package hex.arch.gian.domain.models.users.userData;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
public abstract class UserData {
    private long codUser;
    private String txtName;
    private String txtSurname;
}
