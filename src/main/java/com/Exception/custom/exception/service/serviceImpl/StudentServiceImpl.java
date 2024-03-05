package com.Exception.custom.exception.service.serviceImpl;

import com.Exception.custom.exception.Entity.Student;
import com.Exception.custom.exception.service.StudentService;
import com.Exception.custom.exception.studentrepository.StudentRepository;
import com.Exception.custom.exception.utility.NoStudentExistsException;
import com.Exception.custom.exception.utility.StudentExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository repository;


    @Override
    public Student saveStudent(Student student) {
        try {
            if(repository.findByEmail(student.getEmail()).equals(null))
                  repository.save(student);
            else
                throw new StudentExists(400,"emai exist try again with new");

        }catch (Exception e)
        {
            throw new StudentExists(400,"student alread exist please use new email");
        }
        return student;
    }

    @Override
    public Optional<Student> findByID(Long id) {
        return repository.findById(id);
    }

    @Override
    public ResponseEntity<Student> findByEmail(String email) {
        try {
            Student student= repository.findByEmail(email);
            if(student.equals(email))
            {
                throw new StudentExists(404,"email already exist");
            }
            return new ResponseEntity<>(student,HttpStatus.FOUND);

        }catch (Exception e){

            throw new NoStudentExistsException("no student exist with this email",400);
        }

    }


}
