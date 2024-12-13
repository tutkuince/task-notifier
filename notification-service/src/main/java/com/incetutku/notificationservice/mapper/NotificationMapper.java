package com.incetutku.notificationservice.mapper;

import com.incetutku.notificationservice.dto.NotificationDTO;
import com.incetutku.notificationservice.entity.Notification;

public class NotificationMapper {

    private NotificationMapper() {
    }

    public static Notification mapToNotification(NotificationDTO notificationDTO) {
        return Notification.builder()
                .id(notificationDTO.getId())
                .employeeId(notificationDTO.getEmployeeId())
                .taskId(notificationDTO.getTaskId())
                .taskTitle(notificationDTO.getTaskTitle())
                .taskDescription(notificationDTO.getTaskDescription())
                .build();
    }

    public static NotificationDTO mapToNotificationDTO(Notification notification) {
        return NotificationDTO.builder()
                .id(notification.getId())
                .employeeId(notification.getEmployeeId())
                .taskId(notification.getTaskId())
                .taskTitle(notification.getTaskTitle())
                .taskDescription(notification.getTaskDescription())
                .build();
    }
}
