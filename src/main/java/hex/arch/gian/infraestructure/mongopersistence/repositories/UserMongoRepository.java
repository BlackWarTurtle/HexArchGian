package hex.arch.gian.infraestructure.mongopersistence.repositories;

import hex.arch.gian.infraestructure.mongopersistence.models.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
@ConditionalOnProperty(prefix = "datasource", name = "engine", havingValue = "mongodb")
public interface UserMongoRepository extends MongoRepository<User, String> {



}
