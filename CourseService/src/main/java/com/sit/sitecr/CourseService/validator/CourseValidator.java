/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sit.sitecr.CourseService.validator;

import com.sit.sitecr.CourseService.course.Course;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CourseValidator implements Validator{

    @Override
    public boolean supports(Class<?> aClass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void validate(Object object, Errors errors) {
        
        Course course = (Course) object;
        if(course.getServingAmountOfStudent() ==  course.getAmountOfEnrolledStudent()){
            errors.rejectValue("message", "This course is full, please contact the office");
        }
    }
    
}
