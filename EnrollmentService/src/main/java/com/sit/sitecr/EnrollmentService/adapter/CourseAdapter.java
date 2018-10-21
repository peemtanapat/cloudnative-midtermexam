/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sit.sitecr.EnrollmentService.adapter;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CourseAdapter {

    public Course getCourseFromURL(int courseId) {
        RestTemplate restTemplate = new RestTemplate();
        String urlToCheckAvailableAmountOfStudent = "http://localhost:8090/course/" + courseId;
        Course course = restTemplate.getForObject(urlToCheckAvailableAmountOfStudent, Course.class);
        return course;
    }
}
