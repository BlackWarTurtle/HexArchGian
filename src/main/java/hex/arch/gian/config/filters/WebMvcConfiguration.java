package hex.arch.gian.config.filters;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Component
public class WebMvcConfiguration implements WebMvcConfigurer {

  private final LocaleChangeInterceptor localeChangeInterceptor;

  public WebMvcConfiguration(LocaleChangeInterceptor localeChangeInterceptor) {
    this.localeChangeInterceptor = localeChangeInterceptor;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new MdcInterceptor());
    registry.addInterceptor(localeChangeInterceptor);
  }
}
