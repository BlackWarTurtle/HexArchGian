package hex.arch.gian.infraestructure.mongopersistence.repositories;

import hex.arch.gian.annotations.mongo.MongoComponent;
import hex.arch.gian.infraestructure.mongopersistence.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
@MongoComponent
public interface UserMongoRepository extends MongoRepository<User, String> {}
