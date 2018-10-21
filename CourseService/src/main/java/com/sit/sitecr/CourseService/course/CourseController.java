package com.sit.sitecr.CourseService.course;

import com.sit.sitecr.CourseService.validator.CourseValidator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseValidator courseValidator;

    @RequestMapping(value = "/checkamount/{courseId}", method = RequestMethod.POST)
    public ResponseEntity<Boolean> checkAvailableAmountOfStudent(Model model, @PathVariable("courseId") int courseId) {
        Course course = courseService.findCourseByCourseId(courseId);
        boolean available = courseValidator.checkAvailableAmountOfStudent(course);
        return new ResponseEntity<Boolean>(available, HttpStatus.OK);
    }

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public ResponseEntity<List<Course>> getCourseList(Model model) {
        List<Course> courseList = courseService.findCourseList();
        return new ResponseEntity<List<Course>>(courseList, HttpStatus.OK);
    }

    @RequestMapping(value = "/course/{courseCode}", method = RequestMethod.GET)
    public ResponseEntity<Course> getCourseByCourseCode(Model model, @PathVariable("courseCode") String courseCode) {
        Course course = courseService.findCourseByCourseCode(courseCode);
        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }

    @RequestMapping(value = "/course/{courseId}", method = RequestMethod.GET)
    public ResponseEntity<Course> getCourseByCourseId(Model model, @PathVariable("courseId") int courseId) {
        Course course = courseService.findCourseByCourseId(courseId);
        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }
}
