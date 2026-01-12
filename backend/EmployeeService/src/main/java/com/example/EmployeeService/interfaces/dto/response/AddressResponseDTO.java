package com.example.EmployeeService.interfaces.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponseDTO {

    private String houseNumber;
    private String street;
    private String city;
    private String pincode;

}
