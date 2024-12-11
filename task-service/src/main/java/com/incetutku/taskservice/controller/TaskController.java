package com.incetutku.taskservice.controller;

import com.incetutku.taskservice.dto.TaskDTO;
import com.incetutku.taskservice.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{pageSize}/{pageNumber}")
    public ResponseEntity<List<TaskDTO>> getAllTasksWithPagination(@PathVariable int pageNumber, @PathVariable int pageSize) {
        return ResponseEntity.ok(taskService.getPagination(pageNumber, pageSize));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable String id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO) {
        return new ResponseEntity<>(taskService.save(taskDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable String id, @RequestBody TaskDTO taskDTO) {
        taskDTO.setId(id);
        return new ResponseEntity<>(taskService.update(taskDTO), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TaskDTO> deleteTaskById(@PathVariable String id) {
        return new ResponseEntity<>(taskService.deleteTaskById(id), HttpStatus.NO_CONTENT);
    }
}
