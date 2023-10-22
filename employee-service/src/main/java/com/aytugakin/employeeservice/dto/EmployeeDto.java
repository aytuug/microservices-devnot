package com.aytugakin.employeeservice.dto;
import com.aytugakin.employeeservice.entity.Employee;
import lombok.Builder;

@Builder
public record EmployeeDto(
         Long id,
         String firstName,
         String lastName,
         String email,
         String departmentCode

) {
    public static EmployeeDto convert(Employee employee) {
        return EmployeeDto.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .departmentCode(employee.getDepartmentCode()).build();
    }
}
