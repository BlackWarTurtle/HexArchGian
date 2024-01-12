package hex.arch.gian.infraestructure.rest.validators.users;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class AdultValidator implements ConstraintValidator<Adult, LocalDateTime> {

  private static final int LEGAL_AGE = 18;

  @Override
  public void initialize(Adult constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(LocalDateTime birthDate, ConstraintValidatorContext context) {
    Period period = Period.between(birthDate.toLocalDate(), LocalDate.now());

    return period.getYears() >= LEGAL_AGE;
  }
}
