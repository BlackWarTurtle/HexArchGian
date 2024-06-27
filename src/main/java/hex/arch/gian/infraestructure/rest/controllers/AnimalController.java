package hex.arch.gian.infraestructure.rest.controllers;

import hex.arch.gian.infraestructure.rest.adapters.users.AnimalService;
import hex.arch.gian.infraestructure.rest.adapters.users.CatServiceImpl;
import hex.arch.gian.infraestructure.rest.adapters.users.DogServiceImpl;
import hex.arch.gian.infraestructure.rest.models.animals.Animal;
import hex.arch.gian.infraestructure.rest.models.animals.Cat;
import hex.arch.gian.infraestructure.rest.models.animals.Dog;
import hex.arch.gian.infraestructure.rest.models.users.createuser.CreateUserRequest;
import hex.arch.gian.infraestructure.rest.models.users.createuser.CreateUserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/animals")
@Slf4j
public class AnimalController {

  private final DogServiceImpl dogService;

  private final CatServiceImpl catService;

  @PostMapping
  public ResponseEntity<CreateUserResponse> createCat(@RequestBody Animal createUserRequest) {

    boolean isValid = false;

    if (createUserRequest instanceof Dog dog) {
      isValid = dogService.performAnimalValidation(dog);
    } else if (createUserRequest instanceof Cat cat) {
      isValid = catService.performAnimalValidation(cat);
    }

    log.info("El animal es válido: " + isValid);

    return new ResponseEntity<>(null, HttpStatus.CREATED);
  }
}
