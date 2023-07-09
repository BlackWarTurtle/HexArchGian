package hex.arch.gian.config.exceptions;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> handleConstraintValidations(
      MethodArgumentNotValidException exception) {
    Map<String, String> errors = new HashMap<>();

    var errorList = exception.getBindingResult().getAllErrors();

    errorList.forEach(
        error -> {
          String fieldName = ((FieldError) error).getField();
          String errorMessage = error.getDefaultMessage();
          errors.put(fieldName, errorMessage);
        });

    return errors;
  }

  @ExceptionHandler(ValidationException.class)
  public ResponseEntity<Object> handleValidationExceptions(ValidationException exception) {
    return buildResponseEntityFromValidationException(exception);
  }

  private ResponseEntity<Object> buildResponseEntityFromValidationException(
      ValidationException exception) {
    return new ResponseEntity<>(exception.getValidationExceptionLog(), exception.getHttpStatus());
  }
}
