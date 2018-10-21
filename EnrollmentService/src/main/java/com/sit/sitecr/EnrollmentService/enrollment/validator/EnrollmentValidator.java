package com.sit.sitecr.EnrollmentService.enrollment.validator;

import com.sit.sitecr.EnrollmentService.adapter.Course;
import com.sit.sitecr.EnrollmentService.adapter.Student;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentValidator {

    public boolean cheakCountEnrollOfStudent(Student student) {
        int studentYear = student.getStudentYear();
        boolean result = false;
        if (studentYear == 1 || studentYear == 2) {
            result = true;
        } else if (studentYear == 3) {
            result = true;
        } else if (studentYear == 4) {
            result = true;
        }
        return  result;
    }

    public boolean cheakDuplicatedEnrolledCourse(Course course) {
        return true;
    }
}
