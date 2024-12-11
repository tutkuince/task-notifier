package com.incetutku.taskservice.entity;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Document(indexName = "task_details")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class TaskDetail implements Serializable {
    @Id
    private String id;
    private String employeeId;
    private String employeeName;
    private String employeeSurname;
    private String taskTitle;
    private String taskDescription;
    private String status;
    private String priority;
}
