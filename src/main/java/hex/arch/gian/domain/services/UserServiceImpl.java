package hex.arch.gian.domain.services;

import hex.arch.gian.domain.models.users.DomainUser;
import hex.arch.gian.domain.models.users.userData.CreateUserData;
import hex.arch.gian.domain.models.users.userData.UpdateUserData;
import hex.arch.gian.domain.ports.primaries.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<DomainUser> getAllUsers() {
        return null;
    }

    @Override
    public DomainUser getUserById(final long codUser) {
        return null;
    }

    @Override
    public DomainUser createUser(final CreateUserData createUserData) {
        return null;
    }

    @Override
    public DomainUser updateUser(final UpdateUserData updateUserData) {
        return null;
    }

    @Override
    public void deleteUserById(final long codUser) {

    }
}
