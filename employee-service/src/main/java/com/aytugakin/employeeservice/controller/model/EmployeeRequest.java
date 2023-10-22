package com.aytugakin.employeeservice.controller.model;

import lombok.Builder;

@Builder
public record EmployeeRequest (
        Long id,
        String firstName,
        String lastName,
        String email,
        String departmentCode

) {
}
