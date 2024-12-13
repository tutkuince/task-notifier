package com.incetutku.notificationservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "employee_id")
    private String employeeId;
    @Column(name = "task_id")
    private String taskId;
    @Column(name = "task_title")
    private String taskTitle;
    @Column(name = "task_description")
    private String taskDescription;
}
