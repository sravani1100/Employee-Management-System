package com.example.EmployeeService.interfaces.mapper;

import com.example.EmployeeService.domain.Address;
import com.example.EmployeeService.domain.Employee;
import com.example.EmployeeService.interfaces.dto.request.AddressRequestDTO;
import com.example.EmployeeService.interfaces.dto.request.EmployeeRequestDTO;
import com.example.EmployeeService.interfaces.dto.response.AddressResponseDTO;
import com.example.EmployeeService.interfaces.dto.response.EmployeeResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeMapper {

    public static Employee toEntity(EmployeeRequestDTO employeeRequestDTO){
        Address address = new Address();
        address.setHouseNumber(employeeRequestDTO.getAddress().getHouseNumber());
        address.setStreet(employeeRequestDTO.getAddress().getStreet());
        address.setCity(employeeRequestDTO.getAddress().getCity());
        address.setPincode(employeeRequestDTO.getAddress().getPincode());

        Employee employee = new Employee();
        employee.setName(employeeRequestDTO.getName());
        employee.setEmail(employeeRequestDTO.getEmail());
        employee.setPhoneNumber(employeeRequestDTO.getPhoneNumber());
        employee.setAge(employeeRequestDTO.getAge());
        employee.setRole(employeeRequestDTO.getRole());
        employee.setDepartment(employeeRequestDTO.getDepartment());
        employee.setAddress(address);

        return employee;
    }

    public static EmployeeResponseDTO toResponse(Employee employee){
        AddressResponseDTO address = new AddressResponseDTO();
        address.setHouseNumber(employee.getAddress().getHouseNumber());
        address.setStreet(employee.getAddress().getStreet());
        address.setCity(employee.getAddress().getCity());
        address.setPincode(employee.getAddress().getPincode());

        EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();

        responseDTO.setId(employee.getId());
        responseDTO.setName(employee.getName());
        responseDTO.setEmail(employee.getEmail());
        responseDTO.setPhoneNumber(employee.getPhoneNumber());
        responseDTO.setAge(employee.getAge());
        responseDTO.setRole(employee.getRole());
        responseDTO.setDepartment(employee.getDepartment());
        responseDTO.setAddress(address);

        return responseDTO;
    }
}
