package com.aytugakin.departmentservice.dto;

import com.aytugakin.departmentservice.entity.Department;
import lombok.Builder;

@Builder
public record DepartmentDto(
        Long id,
        String departmentName,
        String departmentDescription,
        String departmentCode
) {
    public static DepartmentDto convert(Department department) {
        return DepartmentDto.builder()
                .id(department.getId())
                .departmentName(department.getDepartmentName())
                .departmentCode(department.getDepartmentCode())
                .departmentDescription(department.getDepartmentDescription()).build();
    }
}
