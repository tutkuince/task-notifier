package com.incetutku.taskservice.mapper;

import com.incetutku.taskservice.dto.TaskDetailDTO;
import com.incetutku.taskservice.entity.TaskDetail;

public class TaskDetailMapper {

    private TaskDetailMapper() {
    }

    public static TaskDetailDTO mapToTaskDetailDTO(TaskDetail taskDetail) {
        return TaskDetailDTO.builder()
                .id(taskDetail.getId())
                .employeeId(taskDetail.getEmployeeId())
                .employeeName(taskDetail.getEmployeeName())
                .employeeSurname(taskDetail.getEmployeeSurname())
                .taskTitle(taskDetail.getTaskTitle())
                .taskDescription(taskDetail.getTaskDescription())
                .status(taskDetail.getStatus())
                .priority(taskDetail.getPriority())
                .build();
    }

    public static TaskDetail mapToTaskDetail(TaskDetailDTO taskDetailDTO) {
        return TaskDetail.builder()
                .id(taskDetailDTO.getId())
                .employeeId(taskDetailDTO.getEmployeeId())
                .employeeName(taskDetailDTO.getEmployeeName())
                .employeeSurname(taskDetailDTO.getEmployeeSurname())
                .taskTitle(taskDetailDTO.getTaskTitle())
                .taskDescription(taskDetailDTO.getTaskDescription())
                .status(taskDetailDTO.getStatus())
                .priority(taskDetailDTO.getPriority())
                .build();
    }
}
