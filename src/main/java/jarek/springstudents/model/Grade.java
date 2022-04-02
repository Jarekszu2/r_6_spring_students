package jarek.springstudents.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private GradeSubject subject;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime dateAdded;

    private double value;

    @ToString.Exclude
    @ManyToOne()
    private Student student;
    public Grade(GradeSubject subject, double value) {
        this.subject = subject;
        this.value = value;
    }
}
