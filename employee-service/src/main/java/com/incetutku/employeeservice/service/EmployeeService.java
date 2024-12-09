package com.incetutku.employeeservice.service;

import com.incetutku.employeeservice.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public List<Employee> getAll();

    public Optional<Employee> getById(String id);

    public Employee save(Employee employee);

    public Employee deleteById(String id);

    public Page<Employee> findPagination(int pageSize, int pageNo, String sortField, String sortDirection);
}
