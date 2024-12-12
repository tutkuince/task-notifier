package com.incetutku.taskservice.service;

import com.incetutku.taskservice.dto.EmployeeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:7202", value = "EMPLOYEE-SERVICE")
public interface APIClient {

    @GetMapping("/api/v1/employees/{id}")
    EmployeeDTO getEmployeeById(@PathVariable String id);
}
