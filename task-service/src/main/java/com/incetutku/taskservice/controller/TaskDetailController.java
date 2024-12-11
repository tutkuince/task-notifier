package com.incetutku.taskservice.controller;

import com.incetutku.taskservice.dto.TaskDetailDTO;
import com.incetutku.taskservice.service.TaskDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/task-details")
@RequiredArgsConstructor
public class TaskDetailController {

    private final TaskDetailService taskDetailService;

    @PostMapping
    public ResponseEntity<TaskDetailDTO> createTaskDetail(@RequestBody TaskDetailDTO taskDetailDTO) {
        return new ResponseEntity<>(taskDetailService.save(taskDetailDTO), HttpStatus.CREATED);
    }
}
