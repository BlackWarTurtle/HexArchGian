package hex.arch.gian.infraestructure.providers.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CoinBaseTokenDTO {

  private Data data;

  public String getName() {
    return this.data.name();
  }

  public String getPrice() {
    return this.data.price();
  }

  public String getCurrency() {
    return this.data.currency();
  }

  public record Data(
      @JsonProperty("base") String name,
      @JsonProperty("amount") String price,
      @JsonProperty("currency") String currency) {}
}
