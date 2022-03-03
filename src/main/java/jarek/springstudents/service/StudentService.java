package jarek.springstudents.service;

import jarek.springstudents.model.Student;
import jarek.springstudents.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getStudentlist() {
        return studentRepository.findAll();
    }
}
