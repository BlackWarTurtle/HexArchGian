package hex.arch.gian.infraestructure.rest.validators.users;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AdultValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Adult {
  String message() default "{legal-age.not.legal}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
