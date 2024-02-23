package hex.arch.gian.config.project.properties;

import hex.arch.gian.config.project.properties.enums.DataSourceEngineEnum;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "project")
@Getter
public class ProjectPropertiesConfig {
  @Value(value = "${project.datasource.engine}")
  private DataSourceEngineEnum projectDatasourceEngine;

  @Value(value = "${project.datasource.host-name}")
  private String datasourceHostName;
}
