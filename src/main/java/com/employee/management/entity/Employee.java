package com.employee.management.entity;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.Min;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false, length = 50)
    @NotBlank(message= "Name is required")
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    @Email(message = "Invalid Email")
    @NotBlank(message = "Email is required")
    private String mail;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate joiningDate;

    @Min(value=0, message= "Salary must be >=0")
    @Column(nullable= false)
    private Double salary;
    

}
