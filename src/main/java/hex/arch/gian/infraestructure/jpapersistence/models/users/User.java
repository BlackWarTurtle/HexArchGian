package hex.arch.gian.infraestructure.jpapersistence.models.users;

import hex.arch.gian.domain.models.enums.UserTypeEnum;
import hex.arch.gian.infraestructure.jpapersistence.models.exams.Exam;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
  @Column(name = "COD_USER", nullable = false)
  private long codUser;

  @Column(name = "TXT_NAME", nullable = false)
  private String txtName;

  @Column(name = "TXT_SURNAME", nullable = false)
  private String txtSurname;

  @Column(name = "IND_TYPE", nullable = false)
  private UserTypeEnum userType;

  @OneToMany(
      mappedBy = "student",
      cascade = CascadeType.ALL,
      fetch = FetchType.LAZY,
      orphanRemoval = true)
  private List<Exam> exams;
}
