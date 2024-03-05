package com.Exception.custom.exception.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
public class Student {


//   @Pattern(regexp ="^[A_Z]\\d{4}\\{3}$")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long std_id;

    private String std_name;

    @Column(unique = true)
//    @Email(message = "GIVE THE VALID EMAIL FORMATE")
    private String email;

//    @Size(min=10, max = 10)
    private Long std_mobile;




}
