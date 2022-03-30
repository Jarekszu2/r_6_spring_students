package jarek.springstudents.controller;

import jarek.springstudents.model.Grade;
import jarek.springstudents.model.GradeSubject;
import jarek.springstudents.service.GradeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/grade/")
public class GradeController {

    private final GradeService gradeService;

    @GetMapping(path = "/add")
    public String gradeForm(Model model, Grade grade) {
        model.addAttribute("at_grade", grade);
        model.addAttribute("at_subjects", GradeSubject.values());

        return "grade-add";
    }

    @PostMapping(path = "/add")
    public String gradeAdd(Grade grade) {
        gradeService.save(grade);

        return "redirect:/grade/list";
    }

    @GetMapping(path = "/list")
    public String list(Model model) {
        List<Grade> gradeList = gradeService.findAll();
        model.addAttribute("at_list_grades", gradeList);

        return "grade-list";
    }
}
