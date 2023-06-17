package hex.arch.gian.domain.ports.primaries;

import hex.arch.gian.domain.models.users.DomainUser;
import hex.arch.gian.domain.models.users.userData.CreateUserData;
import hex.arch.gian.domain.models.users.userData.UpdateUserData;

import java.util.List;

public interface UserService {

    List<DomainUser> getAllUsers();

    DomainUser getUserById(final long codUser);

    DomainUser createUser(final CreateUserData createUserData);

    DomainUser updateUser(final UpdateUserData updateUserData);

    void deleteUserById(final long codUser);

}
