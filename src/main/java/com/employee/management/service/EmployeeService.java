package com.employee.management.service;

import java.util.List;
import java.util.UUID;

import com.employee.management.dto.EmployeeDTO;

public interface EmployeeService {
    public EmployeeDTO createEmployee(EmployeeDTO dto);
    public List<EmployeeDTO> getAllEmployees();
    public EmployeeDTO getEmployeeById(UUID id);
    public List<EmployeeDTO> getEmployeeByName(String name);
    public EmployeeDTO updateEmployeeById(UUID id, EmployeeDTO dto);
    public String deleteEmployee(UUID id);
}
