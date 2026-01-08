package com.example.EmployeeService.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Address extends BaseModal{

    private String houseNumber;
    private String street;
    private String city;
    private String pincode;

    @OneToMany(mappedBy = "address")
    private List<Employee> employeeList;

}
