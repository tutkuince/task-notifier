package com.incetutku.taskservice.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO {
    private String id;
    private String name;
    private String surname;
    private String email;
    private String job;
    private int age;
    private Date createdDate;
}
