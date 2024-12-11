package com.incetutku.taskservice.controller;

import com.incetutku.taskservice.dto.TaskDetailDTO;
import com.incetutku.taskservice.service.TaskDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/task-details")
@RequiredArgsConstructor
public class TaskDetailController {

    private final TaskDetailService taskDetailService;

    @PostMapping
    public ResponseEntity<TaskDetailDTO> createTaskDetail(@RequestBody TaskDetailDTO taskDetailDTO) {
        return new ResponseEntity<>(taskDetailService.save(taskDetailDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskDetailDTO>> getAllTaskDetails() {
        return ResponseEntity.ok(taskDetailService.getAllTaskDetails());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDetailDTO> getTaskDetailById(@PathVariable String id) {
        return ResponseEntity.ok(taskDetailService.getTaskDetailById(id));
    }
}
