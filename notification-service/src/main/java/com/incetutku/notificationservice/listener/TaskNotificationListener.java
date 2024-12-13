package com.incetutku.notificationservice.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.incetutku.notificationservice.dto.TaskNotificationDTO;
import com.incetutku.notificationservice.entity.Notification;
import com.incetutku.notificationservice.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskNotificationListener {

    private final NotificationRepository notificationRepository;

    @RabbitListener(queues = "pro-queue")
    public void handleMessage(String message) throws JsonProcessingException {
        TaskNotificationDTO taskNotificationDTO = new ObjectMapper().readValue(message, TaskNotificationDTO.class);
        Notification notification = Notification.builder()
                .employeeId(taskNotificationDTO.getEmployeeId())
                .taskId(taskNotificationDTO.getTaskId())
                .taskTitle(taskNotificationDTO.getTaskTitle())
                .taskDescription(taskNotificationDTO.getTaskDescription())
                .employeeId(taskNotificationDTO.getEmployeeId())
                .build();

        notificationRepository.save(notification);

        System.out.println("Message received from task-service");
        System.out.println(taskNotificationDTO.toString());
    }
}
