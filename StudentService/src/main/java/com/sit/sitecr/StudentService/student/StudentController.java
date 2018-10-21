package com.sit.sitecr.StudentService.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
       
    @Autowired
    private StudentService studentService;
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity<Student> authentication(Model model,@RequestParam("username")String username, @RequestParam("password")String password){
        Student student = studentService.findStudentByUsernameAndPassword(username, password);
        model.addAttribute("student",student);
        return new ResponseEntity<Student>(student,HttpStatus.OK);
    }
}
