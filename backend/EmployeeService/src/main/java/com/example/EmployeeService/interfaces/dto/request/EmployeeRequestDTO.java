package com.example.EmployeeService.interfaces.dto.request;

import com.example.EmployeeService.domain.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequestDTO {

    private String name;
    private String email;
    private String phoneNumber;
    private int age;
    private String role;
    private String department;


    private AddressRequestDTO address;

}
