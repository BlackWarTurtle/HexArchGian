package hex.arch.gian.config.project;

import hex.arch.gian.config.constants.ConfigConstants;
import hex.arch.gian.config.project.properties.ProjectPropertiesConfig;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProjectConfig {
  private final Environment environment;
  private final ProjectPropertiesConfig projectPropertiesConfig;

  /**
   * Gets datasource hostname. If docker profile is active, the name will be specified by
   * datasource.host-name property, otherwise, hostname will be localhost.
   *
   * <p>Throws exception when docker profile is active but datasource.host-name property is not
   * defined.
   *
   * @return {@code String} datasource hostname.
   */
  public String getDatasourceHostNameByProfile() {
    String datasourceHostname;

    if (!List.of(environment.getActiveProfiles()).contains(ConfigConstants.DOCKER_PROFILE)) {
      datasourceHostname = ConfigConstants.LOCALHOST_CTE;
    } else {
      datasourceHostname =
          Optional.ofNullable(projectPropertiesConfig.getDatasourceHostName())
              .orElseThrow(
                  () -> new RuntimeException("Datasource docker container name is not specified"));
    }

    return datasourceHostname;
  }
}
