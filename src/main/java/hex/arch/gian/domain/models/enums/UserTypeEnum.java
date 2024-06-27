package hex.arch.gian.domain.models.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import hex.arch.gian.config.exceptions.ValidationException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
public enum UserTypeEnum {
  TEACHER(1),
  STUDENT(0);

  private final int code;

  private static final Map<Integer, UserTypeEnum> userTypes = new HashMap<>();

  static {
    Arrays.stream(UserTypeEnum.values()).forEach(e -> userTypes.put(e.getCode(), e));
  }

  public static UserTypeEnum fromCode(final int code) {
    return userTypes.get(code);
  }
}
