package hex.arch.gian.infraestructure.rest.controllers.cryptos;

import hex.arch.gian.infraestructure.rest.adapters.users.TokenAdapter;
import hex.arch.gian.infraestructure.rest.models.tokens.TokenDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tokens")
public class TokensController {

  private final TokenAdapter tokenAdapter;

  @GetMapping("/{tokenId}")
  public ResponseEntity<TokenDTO> getToken(@PathVariable String tokenId) {
    return new ResponseEntity<>(tokenAdapter.getToken(tokenId), HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<TokenDTO>> getToken(@RequestParam List<String> tokenIds) {
    return new ResponseEntity<>(tokenAdapter.getTokens(tokenIds), HttpStatus.OK);
  }
}
