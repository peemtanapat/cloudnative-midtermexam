package com.sit.sitecr.EnrollmentService.enrollment;

import com.sit.sitecr.EnrollmentService.adapter.Course;
import com.sit.sitecr.EnrollmentService.adapter.CourseAdapter;
import com.sit.sitecr.EnrollmentService.adapter.Student;
import com.sit.sitecr.EnrollmentService.adapter.StudentAdapter;
import com.sit.sitecr.EnrollmentService.enrollment.validator.EnrollmentValidator;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnrollmentController {

    private EnrollmentService enrollmentService;
    private StudentAdapter studentAdapter;
    private CourseAdapter courseAdapter;
    private EnrollmentValidator enrollmentValidator;

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService, StudentAdapter studentAdapter, CourseAdapter courseAdapter, EnrollmentValidator enrollmentValidator) {
        this.enrollmentService = enrollmentService;
        this.studentAdapter = studentAdapter;
        this.courseAdapter = courseAdapter;
        this.enrollmentValidator = enrollmentValidator;
    }

    @RequestMapping(value = "/enroll", method = RequestMethod.POST)
    public ResponseEntity<Enrollment> enrollCourse(@RequestBody Enrollment enrollment, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("courseId") int courseId) {
        Student student = studentAdapter.getUserFromAuthentication(username, password);
        Course course = courseAdapter.getCourseFromURL(courseId);
        enrollmentValidator.cheakCountEnrollOfStudent(student);
        enrollmentValidator.cheakDuplicatedEnrolledCourse(course);
        List<Course> courseList = new LinkedList<Course>();
        courseList.add(course);
        enrollmentService.createEnrollment(enrollment, student, courseList);
        return new ResponseEntity<Enrollment>(enrollment, HttpStatus.OK);
    }

}
