package hex.arch.gian.domain.ports.secondaries;

import hex.arch.gian.domain.models.users.DomainUser;

import java.util.List;
import java.util.Optional;

public interface UserPort {

    List<DomainUser> getAllUsers();

    Optional<DomainUser> getUserById(final long codUser);

    DomainUser createUser(final DomainUser domainUser);

    DomainUser updateUser(final DomainUser domainUser);

    void deleteUserById(final long codUser);

    boolean existsById(final long codUser);
}
