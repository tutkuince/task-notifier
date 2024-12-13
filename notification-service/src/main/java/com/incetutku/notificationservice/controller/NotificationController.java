package com.incetutku.notificationservice.controller;

import com.incetutku.notificationservice.dto.NotificationDTO;
import com.incetutku.notificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notifications")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping
    public ResponseEntity<NotificationDTO> create(@RequestBody NotificationDTO notificationDTO) {
        return new ResponseEntity<>(notificationService.save(notificationDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<NotificationDTO>> getAllNotifications() {
        return ResponseEntity.ok(notificationService.getAllNotifications());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificationDTO> getById(@PathVariable long id) {
        return ResponseEntity.ok(notificationService.getNotificationById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificationDTO> update(@PathVariable long id, @RequestBody NotificationDTO notificationDTO) {
        notificationDTO.setId(id);
        return ResponseEntity.ok(notificationService.update(notificationDTO));
    }
}
