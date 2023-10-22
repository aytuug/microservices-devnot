package com.aytugakin.employeeservice.entity;

import com.aytugakin.employeeservice.dto.EmployeeDto;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    private String departmentCode;
    public static Employee convert(EmployeeDto employeeDto) {
        return Employee.builder()
                .id(employeeDto.id())
                .firstName(employeeDto.firstName())
                .lastName(employeeDto.lastName())
                .email(employeeDto.email())
                .departmentCode(employeeDto.departmentCode()).build();
    }
}
