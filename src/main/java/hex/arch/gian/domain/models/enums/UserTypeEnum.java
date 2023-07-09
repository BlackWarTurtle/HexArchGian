package hex.arch.gian.domain.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

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
