package hex.arch.gian.infraestructure.jpapersistence.models.exams;

import hex.arch.gian.domain.models.enums.SubjectsEnum;
import hex.arch.gian.infraestructure.jpapersistence.models.users.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "EXAMS")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_EXAM", nullable = false)
    private long codExam;

    @Column(name = "DEC_SCORE")
    private Double score;

    @Column(name = "IND_SCORE", nullable = false)
    private SubjectsEnum subject;

    @ManyToOne
    @JoinColumn(name = "COD_USER")
    private User student;

}
