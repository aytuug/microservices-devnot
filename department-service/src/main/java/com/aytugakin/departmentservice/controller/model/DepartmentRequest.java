package com.aytugakin.departmentservice.controller.model;

import lombok.Builder;

@Builder
public record DepartmentRequest(
        Long id,
        String departmentName,
        String departmentDescription,
        String departmentCode
) {
}
