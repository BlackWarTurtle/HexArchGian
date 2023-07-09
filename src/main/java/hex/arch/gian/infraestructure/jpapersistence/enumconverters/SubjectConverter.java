package hex.arch.gian.infraestructure.jpapersistence.enumconverters;

import hex.arch.gian.domain.models.enums.SubjectsEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.util.ObjectUtils;

@Converter(autoApply = true)
public class SubjectConverter implements AttributeConverter<SubjectsEnum, Integer> {

  @Override
  public Integer convertToDatabaseColumn(SubjectsEnum subjectsEnum) {
    return !ObjectUtils.isEmpty(subjectsEnum) ? subjectsEnum.getCode() : null;
  }

  @Override
  public SubjectsEnum convertToEntityAttribute(Integer integer) {
    return !ObjectUtils.isEmpty(integer) ? SubjectsEnum.fromCode(integer) : null;
  }
}
