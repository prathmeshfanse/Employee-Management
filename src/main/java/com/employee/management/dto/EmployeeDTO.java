package com.employee.management.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeDTO {
   
    private UUID id;
    
    @NotBlank(message= "Name is required")
    private String name;

    @Email(message = "Invalid Email")
    @NotBlank(message = "Email is required")
    private String mail;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate joiningDate;

    @Min(value=0, message= "Salary must be >=0")
    private Double salary;
}
