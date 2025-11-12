package com.example.Student.Controller;


import com.example.Student.Service.StudentService;
import com.example.Student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    //3 types of Injection

    //1- Field Injection (inject without testing (spring team not recommend it) (organization can use this approach))
    //(Eager Field)
    @Autowired
    private StudentService studentService;

    //2- Constructor Injection (inject with testing) --(why)--> (arguments ==> all required) (cannot any argument to be null) ==> help in testing
    //(Eager Field)
    //private StudentService studentService;
    //@Autowired
    //public StudentController(/*active*/StudentService studentService) {
    //    this.studentService = studentService;
    //}

    //3- Setter Injection (injection -> Lazy Field)
    //private StudentService studentService;
    //@Autowired
    //public void setStudentService(StudentService studentService) {
    //    this.studentService = studentService;
    //}


    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.status(HttpStatus.FOUND).body(student);
        }
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable int id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void removeStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }

}
