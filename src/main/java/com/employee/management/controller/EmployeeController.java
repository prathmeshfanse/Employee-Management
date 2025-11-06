package com.employee.management.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.dto.EmployeeDTO;
import com.employee.management.service.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service){
        this.service = service;
    }

    @PostMapping
    public EmployeeDTO create(@RequestBody EmployeeDTO dto) {
        return service.createEmployee(dto);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployee() {
        return service.getAllEmployees();
    }
    
    @GetMapping("/{id}")
    public EmployeeDTO getById(@PathVariable UUID id) {
        return service.getEmployeeById(id);
    }
    
    @PutMapping("/{id}")
    public EmployeeDTO update(@PathVariable UUID id, @RequestBody EmployeeDTO dto) {
        return service.updateEmployeeById(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable UUID id){
        return service.deleteEmployee(id);
    }
}
