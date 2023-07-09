package hex.arch.gian.domain.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
public enum SubjectsEnum {
  PROGRAMMING(0),
  MATHS(1);

  private final int code;

  private static final Map<Integer, SubjectsEnum> subjects = new HashMap<>();

  static {
    Arrays.stream(SubjectsEnum.values()).forEach(e -> subjects.put(e.getCode(), e));
  }

  public static SubjectsEnum fromCode(final int code) {
    return subjects.get(code);
  }
}
