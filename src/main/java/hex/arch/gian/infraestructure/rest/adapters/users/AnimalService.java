package hex.arch.gian.infraestructure.rest.adapters.users;

import hex.arch.gian.infraestructure.rest.models.animals.Animal;
import org.springframework.util.StringUtils;

public interface AnimalService {

    default boolean performBasicAnimalValidation(Animal animal) {
        return StringUtils.hasLength(animal.getName());
    }

    boolean performAnimalValidation(Animal animal);
}
