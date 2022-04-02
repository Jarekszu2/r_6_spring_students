package jarek.springstudents.service;

import jarek.springstudents.model.Grade;
import jarek.springstudents.model.Student;
import jarek.springstudents.repository.GradeRepository;
import jarek.springstudents.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GradeService {

    private final GradeRepository gradeRepository;
    private final StudentRepository studentRepository;

    public void save(Grade grade, Long studentParam) {
        Student student = studentRepository.getById(studentParam);
        grade.setStudent(student);

        gradeRepository.save(grade);
    }

    public List<Grade> findAll() {
        return gradeRepository.findAll();
    }

    public Optional<Grade> findById(Long variableId) {
        return gradeRepository.findById(variableId);
    }

    public void deleteById(Long deletedId) {
        gradeRepository.deleteById(deletedId);
    }
}
