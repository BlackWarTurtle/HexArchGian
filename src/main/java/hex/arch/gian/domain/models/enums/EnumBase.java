package hex.arch.gian.domain.models.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import hex.arch.gian.config.exceptions.ValidationException;
import org.springframework.http.HttpStatus;

public interface EnumBase<T extends Enum<T>> {
    @JsonCreator
    default T forValue(Class<T> enumType, String value) {
        try {
            return Enum.valueOf(enumType, value);
        } catch (IllegalArgumentException e) {
            throw new ValidationException(HttpStatus.BAD_REQUEST, "Enum name does not match.");
        }
    }
}