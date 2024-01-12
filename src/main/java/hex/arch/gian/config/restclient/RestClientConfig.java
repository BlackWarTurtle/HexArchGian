package hex.arch.gian.config.restclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.http.HttpClient;

@Configuration
public class RestClientConfig {
  @Bean
  public HttpClient httpClient() {
    return HttpClient.newHttpClient();
  }
}
