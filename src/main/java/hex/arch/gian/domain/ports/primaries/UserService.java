package hex.arch.gian.domain.ports.primaries;

import hex.arch.gian.domain.models.users.DomainUser;

import java.util.List;

public interface UserService {

    List<DomainUser> getAllUsers();

    DomainUser getUserById(final long codUser);

    DomainUser createUser(final DomainUser createUserData);

    DomainUser updateUser(final long codUser, final DomainUser updateUserData);

    void deleteUserById(final long codUser);

    void createGraph();
}
