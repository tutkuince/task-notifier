package com.incetutku.taskservice.dto;

import lombok.*;

@Data
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDetailDTO {
    private String id;
    private String employeeId;
    private String employeeName;
    private String employeeSurname;
    private String taskTitle;
    private String taskDescription;
    private String status;
    private String priority;
}
