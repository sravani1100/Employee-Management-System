package com.example.EmployeeService.interfaces.dto.response;

import com.example.EmployeeService.domain.Address;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({
        "id",
        "name",
        "email",
        "phoneNumber",
        "age",
        "role",
        "department"
})
public class EmployeeResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private int age;
    private String role;
    private String department;

    private AddressResponseDTO address;


}
