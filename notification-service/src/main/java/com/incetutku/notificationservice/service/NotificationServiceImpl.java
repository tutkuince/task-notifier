package com.incetutku.notificationservice.service;

import com.incetutku.notificationservice.dto.NotificationDTO;
import com.incetutku.notificationservice.entity.Notification;
import com.incetutku.notificationservice.mapper.NotificationMapper;
import com.incetutku.notificationservice.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    public NotificationDTO save(NotificationDTO notificationDTO) {
        if (Objects.isNull(notificationDTO)) {
            throw new IllegalArgumentException();
        }
        Notification savableNotification = NotificationMapper.mapToNotification(notificationDTO);

        Notification savedNotification = notificationRepository.save(savableNotification);

        notificationDTO.setId(savedNotification.getId());

        return notificationDTO;
    }

    @Override
    public List<NotificationDTO> getAllNotifications() {
        return notificationRepository.findAll().stream().map(NotificationMapper::mapToNotificationDTO).toList();
    }

    @Override
    public NotificationDTO getNotificationById(long id) {
        Notification selectedNotification = notificationRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return NotificationMapper.mapToNotificationDTO(selectedNotification);
    }

    @Override
    public NotificationDTO update(NotificationDTO notificationDTO) {
        Notification selectedNotification = notificationRepository.findById(notificationDTO.getId()).orElseThrow(IllegalArgumentException::new);
        selectedNotification.setEmployeeId(notificationDTO.getEmployeeId());
        selectedNotification.setTaskId(notificationDTO.getTaskId());
        selectedNotification.setTaskTitle(notificationDTO.getTaskTitle());
        selectedNotification.setTaskDescription(notificationDTO.getTaskDescription());

        notificationRepository.save(selectedNotification);

        return notificationDTO;
    }

    @Override
    public NotificationDTO deleteNotificationById(long id) {
        Notification selectedNotification = notificationRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        notificationRepository.deleteById(id);

        return NotificationMapper.mapToNotificationDTO(selectedNotification);
    }
}
