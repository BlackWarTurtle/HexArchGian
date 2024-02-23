package hex.arch.gian.infraestructure.rest.mappers.users;

import hex.arch.gian.config.exceptions.ValidationException;
import hex.arch.gian.config.project.properties.ProjectPropertiesConfig;
import hex.arch.gian.config.project.properties.enums.DataSourceEngineEnum;
import hex.arch.gian.domain.models.users.DomainUser;
import hex.arch.gian.domain.models.users.JpaDomainUser;
import hex.arch.gian.domain.models.users.MongoDomainUser;
import hex.arch.gian.infraestructure.rest.models.users.UserRequest;
import java.util.function.Function;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class UserRequestToDomainUserMapper implements Function<UserRequest, DomainUser> {
  private static final String DATASOURCE_PROPERTY_NOT_CONFIGURED_FOR_USER =
      "datasource.property.not.configured.for.user";
  private final DataSourceEngineEnum dataSourceEngineEnum;

  public UserRequestToDomainUserMapper(ProjectPropertiesConfig projectPropertiesConfig) {
    dataSourceEngineEnum = projectPropertiesConfig.getProjectDatasourceEngine();
  }

  @Override
  public DomainUser apply(UserRequest userRequest) {
    DomainUser domainUser;

    if (DataSourceEngineEnum.MYSQL.equals(dataSourceEngineEnum)) {
      domainUser = JpaDomainUser.builder().id(userRequest.getUserDTO().getId()).build();
    } else if (DataSourceEngineEnum.MONGODB.equals(dataSourceEngineEnum)) {
      domainUser =
          MongoDomainUser.builder().externalId(userRequest.getUserDTO().getExternalId()).build();
    } else {
      throw new ValidationException(
          HttpStatus.INTERNAL_SERVER_ERROR, DATASOURCE_PROPERTY_NOT_CONFIGURED_FOR_USER);
    }

    domainUser.setName(userRequest.getUserDTO().getName());
    domainUser.setSurname(userRequest.getUserDTO().getSurname());
    domainUser.setUserType(userRequest.getUserDTO().getUserType());
    domainUser.setBirthDate(userRequest.getUserDTO().getBirthDate());

    return domainUser;
  }
}
