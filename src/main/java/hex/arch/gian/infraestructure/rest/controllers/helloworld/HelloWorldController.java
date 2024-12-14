package hex.arch.gian.infraestructure.rest.controllers.helloworld;

import hex.arch.gian.infraestructure.rest.models.users.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hello-world")
public class HelloWorldController {

    @GetMapping
    public ResponseEntity<String> getHelloWorld() {
        return new ResponseEntity<>("Hello world", HttpStatus.OK);
    }
}
