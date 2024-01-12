package hex.arch.gian.config.messages;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ValidatorsConfig {
  @Bean
  public LocalValidatorFactoryBean getValidator(MessageSource validationMessagesSource) {
    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
    bean.setValidationMessageSource(validationMessagesSource);
    return bean;
  }
}
