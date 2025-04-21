package com.example.demo.query;

import com.example.demo.enums.SubjectFilterEnum;
import com.example.demo.model.CreateStudentRequest;
import com.example.demo.model.LearningSubject;
import com.example.demo.model.StudentResponse;
import com.example.demo.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;

@Controller
@AllArgsConstructor
public class StudentQuery {
    private final StudentService studentService;
    @QueryMapping
    StudentResponse getStudent(@Argument int id) {
        return studentService.getStudentDetails(id);
    }

    @SchemaMapping(typeName = "StudentResponse")
    List<LearningSubject> learningSubjects(StudentResponse studentResponse, @Argument Set<SubjectFilterEnum> subjectFilter) {
        List<LearningSubject> learningSubjects =  studentResponse.getStudent().getSubjects()
                .stream()
                .filter(subject -> subjectFilter == null || subjectFilter.contains(SubjectFilterEnum.All) || subjectFilter.contains(SubjectFilterEnum.fromString(subject.getSubject())))
                .map(subject -> new LearningSubject(subject.getId(), subject.getSubject(), subject.getMarksObtained()))
                .toList();
        System.out.println("Learning subjects>>>> "+learningSubjects);
        return learningSubjects;
    }

    @MutationMapping
    StudentResponse createStudent(@Argument CreateStudentRequest createStudentRequest) {
        return studentService.createStudent(createStudentRequest);
    }
}
