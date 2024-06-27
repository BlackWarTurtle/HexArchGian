package hex.arch.gian.infraestructure.jpapersistence.models.crypto.tokens.prices;

import hex.arch.gian.infraestructure.jpapersistence.models.crypto.tokens.Token;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TOKEN_PRICES_HISTORY")
public class TokenPricesHistory {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false)
  private long id;

  @Column(name = "DATE", nullable = false)
  private LocalDateTime date;
}
