package com.incetutku.taskservice.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.incetutku.taskservice.dto.TaskNotificationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskNotificationProducer {
    @Value("${ms.rabbit.routing.name}")
    private String routingName;
    @Value("${ms.rabbit.exchange.name}")
    private String exchangeName;

    private final AmqpTemplate amqpTemplate;

    public void sendToQueue(TaskNotificationDTO taskNotificationDTO) throws JsonProcessingException {
        String taskString = new ObjectMapper().writeValueAsString(taskNotificationDTO);
        System.out.println("Notification Sent: " + taskNotificationDTO.toString());
        amqpTemplate.convertAndSend(exchangeName, routingName, taskString);
    }
}
