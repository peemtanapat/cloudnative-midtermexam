package com.sit.sitecr.CourseService.course;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "courses")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    @NotBlank
    private String courseCode;
    @NotBlank
    private String courseName;
    @NotBlank
    private String lecturerName;
    @NotBlank
    @Column(name = "serving_amount")
    private int servingAmountOfStudent;
    @NotBlank
    @Column(name = "enrolled_amount", updatable = true)
    private int enrolledAmountOfStudent;

    public Course() {
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public int getServingAmountOfStudent() {
        return servingAmountOfStudent;
    }

    public void setServingAmountOfStudent(int servingAmountOfStudent) {
        this.servingAmountOfStudent = servingAmountOfStudent;
    }

    public int getAmountOfEnrolledStudent() {
        return enrolledAmountOfStudent;
    }

    public void increaseAmountOfEnrolledStudent() {
        this.enrolledAmountOfStudent = enrolledAmountOfStudent++;
    }

}
