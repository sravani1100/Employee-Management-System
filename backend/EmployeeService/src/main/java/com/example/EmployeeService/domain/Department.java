package com.example.EmployeeService.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Department extends BaseModal{

    private String name;

    @OneToMany(mappedBy = "department")
    private List<Employee> employeeList;
}
