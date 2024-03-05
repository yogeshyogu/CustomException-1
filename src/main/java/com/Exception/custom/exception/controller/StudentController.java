package com.Exception.custom.exception.controller;

import com.Exception.custom.exception.Entity.Student;
import com.Exception.custom.exception.service.StudentService;
import com.Exception.custom.exception.utility.ControllerException;
import com.Exception.custom.exception.utility.NoStudentExistsException;
import com.Exception.custom.exception.utility.StudentExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    StudentService service;


    @PostMapping("/register")
    //localhost:1234/api/student/register
    public Student createStudent(@RequestBody Student student) {
        try {

            Student student1 = service.saveStudent(student);
               return student1;
        }catch (StudentExists se)
        {
            ControllerException ce=new ControllerException(se.getMessage(),se.getStatus());
            throw new ControllerException(se.getMessage(),ce.getStatus());
        }

    }

    @GetMapping("/{id}")//localhost:1234/api/student/{id}
    public Optional<Student> getStudetById(@PathVariable("id") Long id) {


        return service.findByID(id);
        //return new ResponseEntity<ResponseEntity<Student>>(service.findByEmail(email),HttpStatus.OK).getBody();

    }

    @GetMapping("/email")//localhost:1234/email?email=yogesh@gmail.com
    public ResponseEntity<?> getByEmail(@RequestParam String email) {
        try {
            return service.findByEmail(email);
        }catch (NoStudentExistsException e)
        {
            ControllerException ce=new ControllerException(e.getMesg(),e.getStatus());
            return new ResponseEntity<ControllerException>(ce,HttpStatus.NOT_FOUND);
        }

    }
}