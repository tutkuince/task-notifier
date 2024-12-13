package com.incetutku.notificationservice.service;

import com.incetutku.notificationservice.dto.NotificationDTO;

import java.util.List;

public interface NotificationService {
    NotificationDTO save(NotificationDTO notificationDTO);

    List<NotificationDTO> getAllNotifications();

    NotificationDTO getNotificationById(long id);

    NotificationDTO update(NotificationDTO notificationDTO);

    NotificationDTO deleteNotificationById(long id);
}
