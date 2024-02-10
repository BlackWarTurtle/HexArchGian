package hex.arch.gian.infraestructure.mongopersistence.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
@Builder
@Getter
@Setter
public class User {

  @Id private String id;

  private String name;

  private String surname;
}
