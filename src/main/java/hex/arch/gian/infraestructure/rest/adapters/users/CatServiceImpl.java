package hex.arch.gian.infraestructure.rest.adapters.users;

import hex.arch.gian.infraestructure.rest.models.animals.Animal;
import hex.arch.gian.infraestructure.rest.models.animals.Cat;
import hex.arch.gian.infraestructure.rest.models.animals.Dog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
public class CatServiceImpl implements AnimalService {

  @Override
  public boolean performAnimalValidation(Animal animal) {
    Cat cat = (Cat) animal;

    return this.performBasicAnimalValidation(cat)
        && cat.getNumCatYears() > 5
        && StringUtils.hasLength(cat.getColor());
  }
}
