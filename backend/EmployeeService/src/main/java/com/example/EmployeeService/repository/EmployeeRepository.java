package com.example.EmployeeService.repository;

import com.example.EmployeeService.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
