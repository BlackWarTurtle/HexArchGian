package hex.arch.gian.domain.ports.secondaries;

import hex.arch.gian.domain.models.users.DomainUser;
import hex.arch.gian.domain.models.users.userData.CreateUserData;
import hex.arch.gian.domain.models.users.userData.UpdateUserData;

import java.util.List;
import java.util.Optional;

public interface UserPort {

    List<DomainUser> getAllUsers();

    Optional<DomainUser> getUserById(final long codUser);

    DomainUser createUser(final CreateUserData createUserData);

    DomainUser updateUser(final UpdateUserData updateUserData);

    void deleteUserById(final long codUser);
}
