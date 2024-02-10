package hex.arch.gian.domain.models.users;

import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class JpaDomainUser extends DomainUser {
  private Long id;
}
