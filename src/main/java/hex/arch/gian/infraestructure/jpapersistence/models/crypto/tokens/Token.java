package hex.arch.gian.infraestructure.jpapersistence.models.crypto.tokens;

import hex.arch.gian.infraestructure.jpapersistence.models.crypto.tokens.prices.TokenPricesHistory;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TOKENS")
public class Token {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false)
  private long id;

  @Column(name = "NAME", nullable = false)
  private String name;

  @Column(name = "PRICE", nullable = false)
  private BigDecimal price;

  @OneToMany
  @JoinColumn(name = "ID")
  private List<TokenPricesHistory> tokenPricesHistoryList;
}
