package com.example.EmployeeService.application;

import com.example.EmployeeService.domain.Employee;
import com.example.EmployeeService.exception.EmployeeNotFoundException;
import com.example.EmployeeService.infrastructure.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetEmployeeUseCase {

    private final EmployeeRepository employeeRepository;

    public GetEmployeeUseCase(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployeeById(Long id){
        return employeeRepository.findEmployeeById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id "+id));
    }

    public Employee getEmployeeByName(String name){
        return employeeRepository.findEmployeeByName(name).orElseThrow(() -> new EmployeeNotFoundException("Employee not with name "+name));
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
}
