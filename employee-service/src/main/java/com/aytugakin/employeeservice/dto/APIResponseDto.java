package com.aytugakin.employeeservice.dto;

import lombok.Builder;

@Builder
public record APIResponseDto (
        EmployeeDto employeeDto,
        DepartmentDto departmentDto
){
}
