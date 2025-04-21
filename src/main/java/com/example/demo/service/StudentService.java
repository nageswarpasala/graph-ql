package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.entity.Subject;
import com.example.demo.model.CreateStudentRequest;
import com.example.demo.model.StudentResponse;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class StudentService {

    private final Map<Integer, Student> studentDetails;

    StudentService() {
        studentDetails = new ConcurrentHashMap<>();
        studentDetails.put(1,
                new Student(1, "Nageswar", "Manasa", "nag@nag.com",
                    List.of(new Subject(1, "Java", 85.0),
                            new Subject(1, "MongoDB", 80.0),
                            new Subject(1, "GraphQL", 75.0))));
        studentDetails.put(2,
                new Student(2, "Manasa", "Chinnapapireddygari", "manasa@manasa.com",
                        List.of(new Subject(2, "Java", 90.0),
                                new Subject(2, "UIPath", 95.0))));
        studentDetails.put(3,
                new Student(3, "Jasvik", "Pasala", "jasvik@jasvik.com",
                        Collections.emptyList()));
    }

    public StudentResponse getStudentDetails(int id) {
        Optional<Student> student = Optional.ofNullable(studentDetails.get(id));
        if(student.isEmpty()){
            return null;
        }
        StudentResponse response = new StudentResponse();
        response.setId(student.get().getId());
        response.setEmail(student.get().getEmail());
        response.setFirstName(student.get().getFirstName());
        response.setLastName(student.get().getLastName());
        response.setStudent(student.get());

        System.out.println("student details Response>>>>>>{} "+response);

        return response;
    }

    public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {
        int studentId = studentDetails.size()+1;
        studentDetails.put(studentId, new Student(studentId, createStudentRequest.getFirstName(), createStudentRequest.getLastName(),
                createStudentRequest.getEmail(), createStudentRequest.getSubjects()==null?Collections.emptyList():
                createStudentRequest.getSubjects().stream().map(subject -> new Subject(studentId, subject.getSubject(), subject.getMarksObtained()))
                        .toList()));
        return getStudentDetails(studentId);
    }

}
