package com.example.demo.enums;

public enum SubjectFilterEnum {
    All,
    Java,
    UIPath,
    MongoDB,
    GraphQL;

    public static SubjectFilterEnum fromString(String subjectFilter) {
        return SubjectFilterEnum.valueOf(subjectFilter);
    }
}
