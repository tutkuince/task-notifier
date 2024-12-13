package com.incetutku.notificationservice.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.incetutku.notificationservice.dto.TaskNotificationDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class TaskNotificationListener {

    @RabbitListener(queues = "pro-queue")
    public void handleMessage(String message) throws JsonProcessingException {
        TaskNotificationDTO taskNotificationDTO = new ObjectMapper().readValue(message, TaskNotificationDTO.class);
        System.out.println("Message received from task-service");
        System.out.println(taskNotificationDTO.toString());
    }
}
