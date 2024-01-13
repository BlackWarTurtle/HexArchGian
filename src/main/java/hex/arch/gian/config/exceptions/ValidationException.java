package hex.arch.gian.config.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ValidationException extends RuntimeException {

  private final HttpStatus httpStatus;

  private final String errorMessage;

  public ValidationException(HttpStatus httpStatus, String errorMessage) {
    super(errorMessage);
    this.httpStatus = httpStatus;
    this.errorMessage = errorMessage;
  }
}
