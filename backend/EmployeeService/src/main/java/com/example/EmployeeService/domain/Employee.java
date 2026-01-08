package com.example.EmployeeService.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Employee extends BaseModal{

    private String name;
    private String email;
    private String phoneNumber;
    private int age;

    @ManyToOne
    private Role role;

    @ManyToOne
    private Department department;

    @ManyToOne
    private Address address;

}
