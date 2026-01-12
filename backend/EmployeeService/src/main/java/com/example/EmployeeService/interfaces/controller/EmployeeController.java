package com.example.EmployeeService.interfaces.controller;

import com.example.EmployeeService.application.AddEmployeeUseCase;
import com.example.EmployeeService.application.DeleteEmployeeUseCase;
import com.example.EmployeeService.application.GetEmployeeUseCase;
import com.example.EmployeeService.application.UpdateEmployeeUseCase;
import com.example.EmployeeService.domain.Employee;
import com.example.EmployeeService.interfaces.dto.request.EmployeeRequestDTO;
import com.example.EmployeeService.interfaces.dto.response.EmployeeResponseDTO;
import com.example.EmployeeService.interfaces.mapper.EmployeeMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employee")
@RestController
public class EmployeeController {

    private final AddEmployeeUseCase addEmployee;
    private final GetEmployeeUseCase getEmployee;
    private final UpdateEmployeeUseCase updateEmployee;
    private final DeleteEmployeeUseCase deleteEmployee;
    public EmployeeController(AddEmployeeUseCase addEmployee,
                              GetEmployeeUseCase getEmployee,
                              UpdateEmployeeUseCase updateEmployee,
                              DeleteEmployeeUseCase deleteEmployee){

        this.addEmployee = addEmployee;
        this.getEmployee = getEmployee;
        this.updateEmployee = updateEmployee;
        this.deleteEmployee = deleteEmployee;
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeResponseDTO> addEmployee(@RequestBody EmployeeRequestDTO requestDTO){

        Employee employee = EmployeeMapper.toEntity(requestDTO);
        Employee savedEmployee = addEmployee.createEmployee(employee);

        return ResponseEntity.ok(EmployeeMapper.toResponse(savedEmployee));
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees(){
        return ResponseEntity.ok(getEmployee.getAllEmployees().stream()
                                                                .map(EmployeeMapper :: toResponse)
                                                                .toList());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<EmployeeResponseDTO> getEmployeeById(@PathVariable Long id){
        return ResponseEntity.ok(EmployeeMapper.toResponse(getEmployee.getEmployeeById(id)));
    }


    @GetMapping("/name")
    public ResponseEntity<EmployeeResponseDTO> getEmployeeByName(@RequestParam String name){
        return ResponseEntity.ok(EmployeeMapper.toResponse(getEmployee.getEmployeeByName(name)));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeResponseDTO> updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequestDTO employeeRequestDTO){

        Employee employee = EmployeeMapper.toEntity(employeeRequestDTO);
        Employee updatedEmployee = updateEmployee.updateEmployee(id, employee);

        return ResponseEntity.ok(EmployeeMapper.toResponse(updatedEmployee));
    }

    @DeleteMapping("/id/{id}")
    public void deleteEmployee(@PathVariable Long id){
        deleteEmployee.deleteEmployee(id);
    }

}
