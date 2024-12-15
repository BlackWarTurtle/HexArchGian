package hex.arch.gian.infraestructure.jpapersistence.models.users;

import hex.arch.gian.domain.models.enums.UserTypeEnum;
import hex.arch.gian.infraestructure.jpapersistence.models.exams.Exam;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "USERS")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false)
  private long id;

  @Column(name = "NAME", nullable = false)
  private String name;

  @Column(name = "SURNAME", nullable = false)
  private String surname;

  @Column(name = "TYPE", nullable = false)
  private UserTypeEnum userType;

  @Column(name = "PASSWORD", nullable = false)
  private String password;

  @Column(name = "BIRTH_DATE", nullable = false)
  private LocalDateTime birthDate;

  @OneToMany(
      mappedBy = "student",
      cascade = CascadeType.ALL,
      fetch = FetchType.LAZY,
      orphanRemoval = true)
  private List<Exam> exams;
}
