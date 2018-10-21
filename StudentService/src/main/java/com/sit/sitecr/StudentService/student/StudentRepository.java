package com.sit.sitecr.StudentService.student;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long>{
    Optional<Student> findStudentByUsernameAndPassword(String  username, String password);
}
