package com.example.Student.Controller;


import com.example.Student.Service.StudentService;
import com.example.Student.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.GetAllStudent();
    }

    @GetMapping("/{id}")
    public Student getStudentByID(@PathVariable int id){
        return studentService.GetStudentByID(id);
    }

    @PostMapping
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @PutMapping("{id}")
    public void updateStudent(@PathVariable int id,@RequestBody Student student){
        studentService.updateStudent(id, student);
    }

    @DeleteMapping("{id}")
    public void removeStudent(@PathVariable int id){
        studentService.deleteStudent(id);
    }

}
