package com.incetutku.employeeservice.mapper;

import com.incetutku.employeeservice.dto.EmployeeDTO;
import com.incetutku.employeeservice.entity.Employee;

public class EmployeeMapper {

    public static Employee mapToEmployee(EmployeeDTO employeeDTO) {
        return Employee.builder()
                .id(employeeDTO.getId())
                .name(employeeDTO.getName())
                .surname(employeeDTO.getSurname())
                .email(employeeDTO.getEmail())
                .job(employeeDTO.getJob())
                .age(employeeDTO.getAge())
                .build();
    }

    public static EmployeeDTO mapToEmployeeDTO(Employee employee) {
        return EmployeeDTO.builder()
                .id(employee.getId())
                .name(employee.getName())
                .surname(employee.getSurname())
                .email(employee.getEmail())
                .job(employee.getJob())
                .age(employee.getAge())
                .createdDate(employee.getCreatedDate())
                .build();
    }
}
