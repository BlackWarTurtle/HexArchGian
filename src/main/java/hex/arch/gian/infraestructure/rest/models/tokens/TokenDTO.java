package hex.arch.gian.infraestructure.rest.models.tokens;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenDTO {
    private String id;
    private String name;
    private String price;
    private String currency;
}
