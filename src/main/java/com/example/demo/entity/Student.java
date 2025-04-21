package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Subject> subjects;
}
