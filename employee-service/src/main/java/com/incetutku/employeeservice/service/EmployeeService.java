package com.incetutku.employeeservice.service;

import com.incetutku.employeeservice.dto.EmployeeDTO;
import com.incetutku.employeeservice.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public List<EmployeeDTO> getAll();

    public EmployeeDTO getById(String id);

    public EmployeeDTO save(EmployeeDTO employeeDTO);
    public EmployeeDTO update(EmployeeDTO employeeDTO);

    public EmployeeDTO deleteById(String id);

    public Page<EmployeeDTO> findPagination(int pageSize, int pageNo, String sortField, String sortDirection);
}
