package com.employee.management.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.employee.management.dto.EmployeeDTO;
import com.employee.management.entity.Employee;
import com.employee.management.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    // public EmployeeServiceImpl(EmployeeRepository repository){
    //     this.repository = repository;
    // }

    private Employee toEntity(EmployeeDTO dto) {
        return new Employee(dto.getId(),dto.getName(), dto.getMail(), dto.getJoiningDate(), dto.getSalary());
     }  

    private EmployeeDTO toDTO(Employee saved) {
        return new EmployeeDTO(saved.getId(), saved.getName(), saved.getMail(), saved.getJoiningDate(), saved.getSalary());
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO dto) {
        Employee saved = repository.save(toEntity(dto));
        return toDTO(saved);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return repository.findAll()
                        .stream()
                        .map(this :: toDTO)
                        .toList();
    }

    @Override
    public EmployeeDTO getEmployeeById(UUID id) {
        Employee emp =  repository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Employee Not Found"));
        return toDTO(emp);
    }

    @Override
    public List<EmployeeDTO> getEmployeeByName(String name) {
        return repository
                .findByName(name)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public EmployeeDTO updateEmployeeById(UUID id, EmployeeDTO dto) {
        Employee existing = repository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Employee Not Found"));
        
        existing.setName(dto.getName());
        existing.setJoiningDate(dto.getJoiningDate());
        existing.setMail(dto.getMail());
        existing.setSalary(dto.getSalary());

        return toDTO(repository.save(existing));
    }

    @Override
    public String deleteEmployee(UUID id) {
        if(!repository.existsById(id))
            throw new RuntimeException("Employee not found");

        repository.deleteById(id);
        return "Employee deleted";
    }
}
