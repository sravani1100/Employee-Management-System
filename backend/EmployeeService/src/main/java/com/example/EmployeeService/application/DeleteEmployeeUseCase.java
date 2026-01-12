package com.example.EmployeeService.application;

import com.example.EmployeeService.infrastructure.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteEmployeeUseCase {

    private final EmployeeRepository employeeRepository;

    public DeleteEmployeeUseCase(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
}
