package com.example.EmployeeService.infrastructure;

import com.example.EmployeeService.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findEmployeeById(Long empId);
    Optional<Employee> findEmployeeByName(String name);

    
}
