package com.Exception.custom.exception.service;

import com.Exception.custom.exception.Entity.Student;
import org.springframework.http.ResponseEntity;

import java.util.Optional;


public interface StudentService {

     Student saveStudent(Student student);


     Optional<Student> findByID(Long id);

     ResponseEntity<Student> findByEmail(String email);

}
