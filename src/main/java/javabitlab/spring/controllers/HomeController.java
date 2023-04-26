package javabitlab.spring.controllers;
import javabitlab.spring.db.DBManager;
import javabitlab.spring.models.Student;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homePage(Model model){
        List<Student> students = DBManager.getStudents();
        model.addAttribute("students",students);
        return "home";
    }
    @GetMapping("/addStudent")
    public String addStudentPage(Model model){
        return "addStudent";
    }
    @PostMapping("/Students")
    public String NewStudentPage( @RequestParam String name,
                                 @RequestParam String surname,
                                @RequestParam int exam){
        System.out.println(name);
        Student student=new Student();
        student.setName(name);
        student.setExam(exam);
        student.setSurname(surname);
        if(exam<50){
            student.setMark("F");
        } else if (exam<60) {
            student.setMark("D");
        } else if (exam<75) {
            student.setMark("C");
        } else if (exam<90) {
            student.setMark("B");
        }else if(exam>=90){
            student.setMark("A");
        }
        DBManager.addStudent(student);
        return "redirect:/";
    }
}
