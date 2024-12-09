package com.incetutku.employeeservice.controller;

import com.incetutku.employeeservice.dto.EmployeeDTO;
import com.incetutku.employeeservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return new ResponseEntity<>(employeeService.save(employeeDTO), HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee() {
        return ResponseEntity.ok(employeeService.getAll());
    }
}
