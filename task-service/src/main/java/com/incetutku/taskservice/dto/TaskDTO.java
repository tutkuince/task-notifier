package com.incetutku.taskservice.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDTO {

    private String id;
    private String title;
    private String description;
    private String notes;
    private String assignee;
    private Timestamp startDate;
    private String status;
    private String priorityType;
}
