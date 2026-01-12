package com.example.EmployeeService.application;

import com.example.EmployeeService.domain.Employee;
import com.example.EmployeeService.infrastructure.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class AddEmployeeUseCase {

    private final EmployeeRepository employeeRepository;

    public AddEmployeeUseCase(EmployeeRepository employeeRepository){

        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee employee){

        return employeeRepository.save(employee);
    }

}
