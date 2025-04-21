package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Subject {
    private int id;
    private String subject;
    private Double marksObtained;
}
