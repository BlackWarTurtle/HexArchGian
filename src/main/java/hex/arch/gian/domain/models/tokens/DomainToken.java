package hex.arch.gian.domain.models.tokens;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DomainToken {
    private String id;
    private String name;
    private String price;
    private String currency;
}
