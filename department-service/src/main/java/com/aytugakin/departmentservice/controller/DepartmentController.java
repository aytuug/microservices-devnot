package com.aytugakin.departmentservice.controller;

import com.aytugakin.departmentservice.controller.model.DepartmentRequest;
import com.aytugakin.departmentservice.dto.DepartmentDto;
import com.aytugakin.departmentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentRequest departmentRequest) {
        return ResponseEntity.ok(departmentService.saveDepartment(departmentRequest));
    }

    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
        return ResponseEntity.ok(departmentService.getDepartmentByCode(departmentCode));
    }
}
