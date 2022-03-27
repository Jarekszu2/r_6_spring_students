package jarek.springstudents.controller;

import jarek.springstudents.model.Student;
import jarek.springstudents.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/student/")
public class StudentController {
    private final StudentService studentService;

    @GetMapping(path = "/add")
    public String add(Model model, Student student) {
        model.addAttribute("student", student);

        return "student-add";
    }

    @PostMapping(path = "/add")
    public String add(Student student) {
        studentService.add(student);

        return "redirect:/student/list";
    }

    @GetMapping(path = "/edit/{edited_student_id}")
    public String edit(Model model,
                       @PathVariable( name = "edited_student_id") Long studentId) {
        return editStudent(model, studentId);
    }

    @GetMapping(path = "/edit")
    public String editParam(Model model,
                            @RequestParam(name = "edited_student_id") Long studentId) {
        return editStudent(model, studentId);
    }

    private String editStudent(Model model, Long studentId) {
        Optional<Student> studentOptional = studentService.findById(studentId);
        if (studentOptional.isPresent()) {
            model.addAttribute("student", studentOptional.get());
            return "student-add";
        }

        return "redirect:/student/list";
    }

    @GetMapping(path = "/list")
    public String list(Model model) {
        List<Student> studentList = studentService.getStudentlist();
        model.addAttribute("students", studentList);

        return "student-list";
    }

    @GetMapping(path = "/delete/{deleted_student_id}")
    public String delete(@PathVariable(name = "deleted_student_id") Long studentId) {
        return deleteStudent(studentId);
    }

    @GetMapping(path = "/delete")
    public String deleteParam(@RequestParam(name = "deleted_id") Long studentId) {
        return deleteStudent(studentId);
    }

    private String deleteStudent(Long studentId) {
        studentService.deleteById(studentId);

        return "redirect:/student/list";
    }
}
