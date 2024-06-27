package hex.arch.gian.infraestructure.jpapersistence.repositories.crypto;

import hex.arch.gian.annotations.jpa.JpaComponent;
import hex.arch.gian.infraestructure.jpapersistence.models.crypto.users.tokens.UserTokenPurchase;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@JpaComponent
public interface UserTokenPurchaseJpaRepository {

    List<UserTokenPurchase> findAllUserTokens();
}
