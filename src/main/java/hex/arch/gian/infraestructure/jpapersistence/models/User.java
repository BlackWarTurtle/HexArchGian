package hex.arch.gian.infraestructure.jpapersistence.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codUser;

    @Column(nullable = false)
    private String txtName;

    @Column(nullable = false)
    private String txtSurname;

}
