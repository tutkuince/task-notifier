package com.incetutku.employeeservice.service;

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
    public List<Employee> getAll() {
        return List.of();
    }

    @Override
    public Optional<Employee> getById(String id) {
        return Optional.empty();
    }

    @Override
    public Employee save(Employee employee) {
        return null;
    }

    @Override
    public Employee deleteById(String id) {
        return null;
    }

    @Override
    public Page<Employee> findPagination(int pageSize, int pageNo, String sortField, String sortDirection) {
        return null;
    }
}
