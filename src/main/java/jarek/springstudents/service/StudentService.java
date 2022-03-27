package jarek.springstudents.service;

import jarek.springstudents.model.Student;
import jarek.springstudents.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getStudentlist() {
        return studentRepository.findAll();
    }

    public void add(Student student) {
        studentRepository.save(student);
    }

    public Optional<Student> findById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    public void deleteById(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
