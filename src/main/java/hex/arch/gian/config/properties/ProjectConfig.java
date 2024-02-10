package hex.arch.gian.config.properties;

import hex.arch.gian.config.properties.enums.DataSourceEngineEnum;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "project")
@Getter
public class ProjectConfig {

    @Value(value = "${project.datasource.engine}")
    private DataSourceEngineEnum projectDatasourceEngine;

}
