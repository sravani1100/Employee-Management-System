package com.example.EmployeeService.interfaces.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequestDTO {

    private String houseNumber;
    private String street;
    private String city;
    private String pincode;

}
