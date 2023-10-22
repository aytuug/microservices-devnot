package com.aytugakin.employeeservice.dto;

import lombok.Builder;

@Builder
public record DepartmentDto(
        Long id,
        String departmentName,
        String departmentDescription,
        String departmentCode
) {
}
