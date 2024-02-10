package hex.arch.gian.config.datasources;

import hex.arch.gian.annotations.jpa.JpaComponent;
import javax.sql.DataSource;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:application.properties")
@JpaComponent
public class JpaConfig {

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/hex_arch_database");
    dataSource.setUsername("root");
    dataSource.setPassword("admin");
    return dataSource;
  }

  @Bean
  public PhysicalNamingStrategy physical() {
    return new PhysicalNamingStrategyStandardImpl();
  }
}
