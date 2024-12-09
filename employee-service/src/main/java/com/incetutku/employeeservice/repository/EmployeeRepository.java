package com.incetutku.employeeservice.repository;

import com.incetutku.employeeservice.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

}
