package com.example.EmployeeService.application;

import com.example.EmployeeService.domain.Address;
import com.example.EmployeeService.domain.Employee;
import com.example.EmployeeService.exception.EmployeeNotFoundException;
import com.example.EmployeeService.infrastructure.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateEmployeeUseCase {

    private final EmployeeRepository employeeRepository;

    public UpdateEmployeeUseCase(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public Employee updateEmployee(Long id,Employee employee){
        Employee existingEmployee = employeeRepository.findEmployeeById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found! Please give existing employee details to update. "));

        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPhoneNumber(employee.getPhoneNumber());
        existingEmployee.setAge(employee.getAge());
        existingEmployee.setRole(employee.getRole());
        existingEmployee.setDepartment(employee.getDepartment());

        Address address = existingEmployee.getAddress();
        address.setHouseNumber(employee.getAddress().getHouseNumber());
        address.setStreet(employee.getAddress().getStreet());
        address.setCity(employee.getAddress().getCity());
        address.setPincode(employee.getAddress().getPincode());

        existingEmployee.setAddress(address);

        return employeeRepository.save(existingEmployee);
    }
}
