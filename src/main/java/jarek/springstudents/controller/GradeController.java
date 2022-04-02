package jarek.springstudents.controller;

import jarek.springstudents.model.Grade;
import jarek.springstudents.model.GradeSubject;
import jarek.springstudents.service.GradeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/grade/")
public class GradeController {

    private final GradeService gradeService;

    @GetMapping(path = "/add/{student_Id}")
    public String gradeForm(Model model, Grade grade,
                            @PathVariable(name = "student_Id") Long studentId) {
        model.addAttribute("at_grade", grade);
        model.addAttribute("at_subjects", GradeSubject.values());
        model.addAttribute("at_studentId", studentId);

        return "grade-add";
    }

    @PostMapping(path = "/add")
    public String gradeAdd(Grade grade, Long studentParam) {
        gradeService.save(grade, studentParam);

        return "redirect:/grade/list";
    }

    @GetMapping(path = "/list")
    public String list(Model model) {
        List<Grade> gradeList = gradeService.findAll();
        model.addAttribute("at_list_grades", gradeList);

        return "grade-list";
    }

    @GetMapping(path = "/edit/{edited_Id}")
    public String editGradeByPathVariable(Model model,
                                          @PathVariable(name = "edited_Id") Long variableId) {
        Optional<Grade> optionalGrade = gradeService.findById(variableId);
        if (optionalGrade.isPresent()) {
            model.addAttribute("at_grade", optionalGrade.get());
            model.addAttribute("at_subjects", GradeSubject.values());
            model.addAttribute("at_studentId", optionalGrade.get().getStudent().getId());

            return "grade-add";
        }

        return "redirect:/grade/list";
    }

    @GetMapping(path = "/delete/{deleted_Id}")
    public String deleteByPathVariable(@PathVariable(name = "deleted_Id") Long deletedId) {
        gradeService.deleteById(deletedId);

        return "redirect:/grade/list";
    }

}
