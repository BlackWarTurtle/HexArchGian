package hex.arch.gian.infraestructure.jpapersistence.models.crypto.users.tokens;

import hex.arch.gian.infraestructure.jpapersistence.models.crypto.tokens.Token;
import hex.arch.gian.infraestructure.jpapersistence.models.users.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "USER_TOKEN_PURCHASE")
public class UserTokenPurchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private long id;

    @Column(name = "DATE", nullable = false)
    private LocalDateTime date;
}
