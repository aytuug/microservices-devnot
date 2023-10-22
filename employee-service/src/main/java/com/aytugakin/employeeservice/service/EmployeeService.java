package com.aytugakin.employeeservice.service;

import com.aytugakin.employeeservice.controller.model.EmployeeRequest;
import com.aytugakin.employeeservice.dto.APIResponseDto;
import com.aytugakin.employeeservice.dto.DepartmentDto;
import com.aytugakin.employeeservice.dto.EmployeeDto;
import com.aytugakin.employeeservice.entity.Employee;
import com.aytugakin.employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    //private final RestTemplate restTemplate;
    //private final WebClient webClient;
    private final APIClient apiClient;
    public EmployeeDto saveDepartment(EmployeeRequest employeeRequest) {
        return EmployeeDto.convert(employeeRepository.save(
                Employee.builder()
                        .id(employeeRequest.id())
                        .firstName(employeeRequest.firstName())
                        .lastName(employeeRequest.lastName())
                        .email(employeeRequest.email())
                        .departmentCode(employeeRequest.departmentCode())
                        .build()
        ));
    }

    public APIResponseDto getEmployeeById(Long id) {

        Employee employee = employeeRepository.findById(id).get();
        //ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class);
        /*
        DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();
         */

        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        return  APIResponseDto.builder()
                .employeeDto(EmployeeDto.convert(employee))
                .departmentDto(departmentDto)
                .build();
    }
}
