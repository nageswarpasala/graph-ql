package com.example.demo.model;

import com.example.demo.entity.Subject;
import lombok.Data;

import java.util.List;

@Data
public class CreateStudentRequest {
    private String firstName;
    private String lastName;
    private String email;
    private List<CreateSubjectRequest> subjects;
}
