package hex.arch.gian.config.exceptions;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
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

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(HttpMessageNotReadableException.class)
  public Map<String, String> handleMessageNotReadableException(
      HttpMessageNotReadableException exception) {
    Map<String, String> errors = new HashMap<>();

    Throwable mostSpecificCause = exception.getMostSpecificCause();

    if (mostSpecificCause instanceof InvalidFormatException invalidFormatException
        && invalidFormatException.getTargetType().isEnum()) {
      String enumName = invalidFormatException.getTargetType().getSimpleName();
      Object[] enumConstants = invalidFormatException.getTargetType().getEnumConstants();

      errors.put(
          "Deserializing Enum error",
          enumName + " allowed values: " + Arrays.toString(enumConstants));
    } else {
      errors.put("Deserializing error", exception.getMessage());
    }

    return errors;
  }

  @ExceptionHandler(ValidationException.class)
  public ProblemDetail handleValidationExceptions(ValidationException exception) {
    return ProblemDetail.forStatusAndDetail(exception.getHttpStatus(), exception.getErrorMessage());
  }
}
