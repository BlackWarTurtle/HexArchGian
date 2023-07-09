package hex.arch.gian.config.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ValidationException extends RuntimeException {

  private final HttpStatus httpStatus;

  private final ValidationExceptionLog validationExceptionLog;

  public ValidationException(HttpStatus httpStatus, String errorMessage) {
    super(errorMessage);
    this.httpStatus = httpStatus;
    validationExceptionLog = new ValidationExceptionLog(httpStatus, errorMessage);
  }

  private record ValidationExceptionLog(HttpStatus httpStatus, String errorMessage) {}
}
