package com.sit.sitecr.StudentService.student;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student findStudentByUsernameAndPassword(String username, String password) {
        Student student = studentRepository.findStudentByUsernameAndPassword(username, password).get();
        return student;
    }
}
