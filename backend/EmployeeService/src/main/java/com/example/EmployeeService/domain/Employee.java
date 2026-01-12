package com.example.EmployeeService.domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.CascadeType;
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
    private String role;
    private String department;

    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;

}
