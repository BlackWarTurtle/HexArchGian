package hex.arch.gian.infraestructure.rest.adapters.users;

import hex.arch.gian.infraestructure.rest.models.animals.Animal;
import hex.arch.gian.infraestructure.rest.models.animals.Dog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
public class DogServiceImpl implements AnimalService {

  @Override
  public boolean performAnimalValidation(Animal animal) {
    Dog dog = (Dog) animal;

    return this.performBasicAnimalValidation(dog)
        && dog.getNumDogYears() > 5
        && StringUtils.hasLength(dog.getSound());
  }
}
