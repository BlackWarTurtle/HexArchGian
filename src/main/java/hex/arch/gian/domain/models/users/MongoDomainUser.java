package hex.arch.gian.domain.models.users;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class MongoDomainUser extends DomainUser {
  private String externalId;
}
