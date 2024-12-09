package com.incetutku.employeeservice.service;

import com.incetutku.employeeservice.dto.EmployeeDTO;
import com.incetutku.employeeservice.entity.Employee;
import com.incetutku.employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDTO> getAll() {
        return List.of();
    }

    @Override
    public Optional<EmployeeDTO> getById(String id) {
        return Optional.empty();
    }

    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        Employee employee = Employee.builder()
                .name(employeeDTO.getName())
                .surname(employeeDTO.getSurname())
                .email(employeeDTO.getEmail())
                .job(employeeDTO.getJob())
                .age(employeeDTO.getAge())
                .build();

        Employee savedEmployee = employeeRepository.save(employee);

        employeeDTO.setId(savedEmployee.getId());
        employeeDTO.setCreatedDate(savedEmployee.getCreatedDate());

        return employeeDTO;
    }

    @Override
    public EmployeeDTO deleteById(String id) {
        return null;
    }

    @Override
    public Page<EmployeeDTO> findPagination(int pageSize, int pageNo, String sortField, String sortDirection) {
        return null;
    }
}
