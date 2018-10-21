package com.sit.sitecr.CourseService.course.validator;

import com.sit.sitecr.CourseService.course.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseValidator {

    public boolean checkAvailableAmountOfStudent(Course course) {
        boolean available = true;
        if (course.getServingAmountOfStudent() == course.getAmountOfEnrolledStudent()) {
            available = false;
        }
        return available;
    }

}
