package com.aytugakin.departmentservice.service;

import com.aytugakin.departmentservice.controller.model.DepartmentRequest;
import com.aytugakin.departmentservice.dto.DepartmentDto;
import com.aytugakin.departmentservice.entity.Department;
import com.aytugakin.departmentservice.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    public DepartmentDto saveDepartment(DepartmentRequest departmentRequest) {
        return DepartmentDto.convert(departmentRepository.save(
                Department.builder()
                        .id(departmentRequest.id())
                        .departmentName(departmentRequest.departmentName())
                        .departmentCode(departmentRequest.departmentCode())
                        .departmentDescription(departmentRequest.departmentDescription()).build()
        ));
    }

    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        return DepartmentDto.convert(department);
    }

}
