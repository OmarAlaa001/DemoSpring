package com.example.Student.Service;


import com.example.Student.model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private List<Student> students = new ArrayList<>();

    //Bean Post Processor
    @PostConstruct
    public void init() {
        System.out.println("start post construct");
        addStudent(new Student("Omar", 25));
        addStudent(new Student("ahmed", 26));
        addStudent(new Student("Mariam", 22));
        System.out.println("end post construct");
    }


    public List<Student> getAllStudent() {
        return students;
    }

    public Student getStudentById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }


    public void addStudent(Student student) {
        student.setId(students.size() + 1); // server assigns Id
        students.add(student);
    }

    public void updateStudent(int id, Student newStudent) {
        for (Student s : students) {
            if (s.getId() == id) {
                if (newStudent.getName() != null) {
                    s.setName(newStudent.getName());
                }
                if (newStudent.getAge() != 0) {
                    s.setAge(newStudent.getAge());
                }
                return;
            }
        }
    }

    public void deleteStudent(int id) {
        students.removeIf(s -> s.getId() == id);
    }


}
