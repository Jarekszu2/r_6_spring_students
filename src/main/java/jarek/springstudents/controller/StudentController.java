package jarek.springstudents.controller;

import jarek.springstudents.model.Student;
import jarek.springstudents.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/student/")
public class StudentController {
    private final StudentService studentService;

    @GetMapping(path = "/add")
    public String add() {
        return "student-add";
    }

    @GetMapping(path = "/list")
    public String list(Model model) {
        List<Student> studentList = studentService.getStudentlist();
        model.addAttribute("students", studentList);
        return "student-list";
    }
}