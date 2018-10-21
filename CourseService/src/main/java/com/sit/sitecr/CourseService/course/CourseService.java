package com.sit.sitecr.CourseService.course;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> findCourseList() {
        List<Course> courseList = courseRepository.findAll();
        return courseList;
    }

    public Course findCourseByCourseCode(String courseCode) {
        Course course = courseRepository.findCourseByCourseCode(courseCode).get();
        return course;
    }

    public Course findCourseByCourseId(int courseId) {
        Course course = courseRepository.findCourseByCourseId(courseId).get();
        return course;
    }

}
