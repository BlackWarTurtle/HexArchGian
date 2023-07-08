package hex.arch.gian.infraestructure.jpapersistence.repositories;

import hex.arch.gian.infraestructure.jpapersistence.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersJpaRepository extends JpaRepository<User, Long> {}
