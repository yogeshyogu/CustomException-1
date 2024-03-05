package com.Exception.custom.exception.studentrepository;


import com.Exception.custom.exception.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

   Optional<Student> findById(Long id);


   Student findByEmail(String email);
}
