package com.example.demo.model;

import com.example.demo.entity.Student;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
public class StudentResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private List<LearningSubject> learningSubjects;
    @ToString.Exclude
    private Student student;
}
