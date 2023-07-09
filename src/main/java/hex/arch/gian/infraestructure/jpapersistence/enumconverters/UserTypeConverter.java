package hex.arch.gian.infraestructure.jpapersistence.enumconverters;

import hex.arch.gian.domain.models.enums.UserTypeEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.util.ObjectUtils;

@Converter(autoApply = true)
public class UserTypeConverter implements AttributeConverter<UserTypeEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(UserTypeEnum UserTypeEnum) {
        return !ObjectUtils.isEmpty(UserTypeEnum) ? UserTypeEnum.getCode() : null;
    }

    @Override
    public UserTypeEnum convertToEntityAttribute(Integer integer) {
        return !ObjectUtils.isEmpty(integer) ? UserTypeEnum.fromCode(integer) : null;
    }
}
