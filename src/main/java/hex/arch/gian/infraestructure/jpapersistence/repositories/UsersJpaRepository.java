package hex.arch.gian.infraestructure.jpapersistence.repositories;

import hex.arch.gian.annotations.jpa.JpaComponent;
import hex.arch.gian.infraestructure.jpapersistence.models.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@JpaComponent
public interface UsersJpaRepository extends JpaRepository<User, Long> {

  Optional<User> findByName(String name);
}
