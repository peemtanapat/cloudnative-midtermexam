package com.sit.sitecr.EnrollmentService.enrollment;

import com.sit.sitecr.EnrollmentService.adapter.Course;
import com.sit.sitecr.EnrollmentService.adapter.CourseAdapter;
import com.sit.sitecr.EnrollmentService.adapter.Student;
import com.sit.sitecr.EnrollmentService.adapter.StudentAdapter;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public Enrollment createEnrollment(@Valid Enrollment enrollment, Student student, List<Course> course) {
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollmentRepository.save(enrollment);
        return enrollment;

    }
}
