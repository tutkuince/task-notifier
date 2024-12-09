package com.incetutku.employeeservice.service;

import com.incetutku.employeeservice.dto.EmployeeDTO;
import com.incetutku.employeeservice.entity.Employee;
import com.incetutku.employeeservice.mapper.EmployeeMapper;
import com.incetutku.employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDTO> getAll() {
        return employeeRepository.findAll().stream().map(EmployeeMapper::mapToEmployeeDTO).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getById(String id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(IllegalAccessError::new);
        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);

        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO update(EmployeeDTO employeeDTO) {
        Employee selectedEmployee = employeeRepository.findById(employeeDTO.getId()).orElseThrow(IllegalAccessError::new);
        selectedEmployee.setName(employeeDTO.getName());
        selectedEmployee.setSurname(employeeDTO.getSurname());
        selectedEmployee.setEmail(employeeDTO.getEmail());
        selectedEmployee.setJob(employeeDTO.getJob());
        selectedEmployee.setAge(employeeDTO.getAge());

        employeeRepository.save(selectedEmployee);
        return EmployeeMapper.mapToEmployeeDTO(selectedEmployee);
    }

    @Override
    public EmployeeDTO deleteById(String id) {
        Employee selectedEmployee = employeeRepository.findById(id).orElseThrow(IllegalAccessError::new);
        employeeRepository.deleteById(id);
        return EmployeeMapper.mapToEmployeeDTO(selectedEmployee);
    }

    @Override
    public Page<EmployeeDTO> findPagination(int pageSize, int pageNo, String sortField, String sortDirection) {
        return null;
    }
}
