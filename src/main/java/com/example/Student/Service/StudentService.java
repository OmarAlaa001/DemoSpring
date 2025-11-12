package com.example.Student.Service;


import com.example.Student.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private int nextid = 1;
    private List<Student> students = new ArrayList<>(
            List.of(
                    new Student("Omar", nextid, 25),
                    new Student("ahmed", nextid, 26),
                    new Student("Mariam", nextid, 22)
            )
    );




    public List<Student> GetAllStudent(){
        return students;
    }

    public Student GetStudentByID(int ID){
        return students.stream()
                .filter(s -> s.getID() == ID)
                .findFirst()
                .orElse(null);
    }

    public void addStudent(Student student){
        student.setID(nextid++); // server assigns ID
        students.add(student);


    }

    public void updateStudent(int ID,Student newStudent){
        for(Student s: students){
            if(s.getID() == ID){
                s.setName(newStudent.getName());
                s.setAge(newStudent.getAge());
                return;
            }
        }
    }

    public void deleteStudent(int ID){
        students.removeIf(s -> s.getID() == ID );
    }

    
}
