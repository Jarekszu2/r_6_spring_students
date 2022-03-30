package jarek.springstudents.service;

import jarek.springstudents.model.Grade;
import jarek.springstudents.repository.GradeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GradeService {

    private final GradeRepository gradeRepository;

    public void save(Grade grade) {
        gradeRepository.save(grade);
    }

    public List<Grade> findAll() {
        return gradeRepository.findAll();
    }
}
