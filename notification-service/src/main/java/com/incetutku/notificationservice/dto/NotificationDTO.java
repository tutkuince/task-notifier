package com.incetutku.notificationservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationDTO {
    private long id;
    private String employeeId;
    private String taskId;
    private String taskTitle;
    private String taskDescription;
}
