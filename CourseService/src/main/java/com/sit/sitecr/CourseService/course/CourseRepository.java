package com.sit.sitecr.CourseService.course;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    Optional<Course> findCourseByCourseId(int courseId);

    Optional<Course> findCourseByCourseCode(String courseCode);
}
