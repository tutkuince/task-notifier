package com.incetutku.taskservice.controller;

import com.incetutku.taskservice.dto.TaskDetailDTO;
import com.incetutku.taskservice.service.TaskDetailService;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.service.GenericResponseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/task-details")
@RequiredArgsConstructor
public class TaskDetailController {

    private final TaskDetailService taskDetailService;
    private final GenericResponseService responseBuilder;

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

    @GetMapping("/description/{description}")
    public ResponseEntity<List<TaskDetailDTO>> getByDescription(@PathVariable String description) {
        return ResponseEntity.ok(taskDetailService.getWithContainTaskDescription(description));
    }

    @GetMapping("/name/{employeeName}")
    public ResponseEntity<List<TaskDetailDTO>> getByEmployeeName(@PathVariable String employeeName) {
        return ResponseEntity.ok(taskDetailService.getWithStartsName(employeeName));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDetailDTO> updateTaskDetail(@PathVariable String id, @RequestBody TaskDetailDTO taskDetailDTO) {
        taskDetailDTO.setId(id);
        return ResponseEntity.ok(taskDetailService.updateTaskDetail(taskDetailDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TaskDetailDTO> deleteTaskDetailById(@PathVariable String id) {
        return ResponseEntity.ok(taskDetailService.deleteTaskDetailById(id));
    }
}
