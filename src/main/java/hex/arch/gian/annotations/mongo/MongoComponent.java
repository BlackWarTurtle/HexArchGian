package hex.arch.gian.annotations.mongo;

import java.lang.annotation.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
@ConditionalOnProperty(prefix = "project", name = "datasource.engine", havingValue = "MONGODB")
public @interface MongoComponent {}
