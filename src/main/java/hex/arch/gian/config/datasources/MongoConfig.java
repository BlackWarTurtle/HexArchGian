package hex.arch.gian.config.datasources;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import jakarta.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Collections;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
@PropertySource("classpath:application.properties")
@ConditionalOnProperty(prefix = "datasource", name = "engine", havingValue = "mongodb")
public class MongoConfig extends AbstractMongoClientConfiguration {

  private static final String MONGO_BASE_PACKAGE = "hex.arch.gian.infraestructure.mongopersistence";

  @Override
  protected @NotNull String getDatabaseName() {
    return "hexarchdb";
  }

  @Override
  public @NotNull MongoClient mongoClient() {
    ConnectionString connectionString =
        new ConnectionString("mongodb://localhost:27017" + "/" + "hexarchdb");
    MongoClientSettings mongoClientSettings =
        MongoClientSettings.builder().applyConnectionString(connectionString).build();

    return MongoClients.create(mongoClientSettings);
  }

  @Override
  public @NotNull Collection<String> getMappingBasePackages() {
    return Collections.singleton(MONGO_BASE_PACKAGE);
  }
}
