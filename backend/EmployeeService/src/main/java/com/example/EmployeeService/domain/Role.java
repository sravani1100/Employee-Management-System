package com.example.EmployeeService.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Role extends BaseModal{

    private String name;

    @OneToMany(mappedBy = "role")
    private List<Employee> employeeList;
}
