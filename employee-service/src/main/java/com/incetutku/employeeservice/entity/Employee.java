package com.incetutku.employeeservice.entity;

import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "employees")
@Builder
public class Employee {

    @Id
    private String id;

    @NotEmpty
    private String name;

    private String surname;

    @Size(min = 10, max = 50)
    @Email
    @Pattern(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String email;

    private String job;

    @Min(18)
    @Max(100)
    private int age;

    @CreationTimestamp
    private Date createdDate;
}
