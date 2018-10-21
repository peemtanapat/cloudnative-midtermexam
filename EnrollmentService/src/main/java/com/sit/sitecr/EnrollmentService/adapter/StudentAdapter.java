package com.sit.sitecr.EnrollmentService.adapter;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StudentAdapter {

    public Student getUserFromAuthentication(String username, String password) {
        RestTemplate restTemplate = new RestTemplate();
        String urlToGetStudent = "http://localhost:8080/login?username=" + username + "&" + "password=" + password;
        Student student = restTemplate.getForObject(urlToGetStudent, Student.class);
        return student;
    }
}
