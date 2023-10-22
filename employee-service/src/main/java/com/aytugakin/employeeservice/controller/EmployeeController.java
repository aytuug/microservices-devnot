package com.aytugakin.employeeservice.controller;

import com.aytugakin.employeeservice.controller.model.EmployeeRequest;
import com.aytugakin.employeeservice.dto.APIResponseDto;
import com.aytugakin.employeeservice.dto.EmployeeDto;
import com.aytugakin.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveDepartment(@RequestBody EmployeeRequest employeeRequest) {
        return ResponseEntity.ok(employeeService.saveDepartment(employeeRequest));
    }

    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable("id") Long id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }
}
