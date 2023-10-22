package com.aytugakin.departmentservice.entity;


import com.aytugakin.departmentservice.dto.DepartmentDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;

    public static Department convert(DepartmentDto departmentDto) {
        return Department.builder()
                .id(departmentDto.id())
                .departmentName(departmentDto.departmentName())
                .departmentCode(departmentDto.departmentCode())
                .departmentDescription(departmentDto.departmentDescription()).build();
    }
}
