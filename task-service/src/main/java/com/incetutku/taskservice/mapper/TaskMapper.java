package com.incetutku.taskservice.mapper;

import com.incetutku.taskservice.dto.TaskDTO;
import com.incetutku.taskservice.entity.PriorityType;
import com.incetutku.taskservice.entity.Status;
import com.incetutku.taskservice.entity.Task;

import java.sql.Timestamp;
import java.util.Objects;

public final class TaskMapper {

    private TaskMapper() {
    }

    public static Task mapToTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setNotes(taskDTO.getNotes());
        task.setAssignee(taskDTO.getAssignee());
        task.setStartDate(Objects.isNull(taskDTO.getStartDate()) ? null : Timestamp.valueOf(taskDTO.getStartDate().toLocalDateTime()));
        task.setStatus(Status.valueOf(taskDTO.getStatus()));
        task.setPriorityType(PriorityType.valueOf(taskDTO.getPriorityType()));
        return task;
    }

    public static TaskDTO mapToTaskDTO(Task task) {
        return TaskDTO.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .notes(task.getNotes())
                .assignee(task.getAssignee())
                .startDate(task.getStartDate())
                .status(task.getStatus().toString())
                .priorityType(task.getPriorityType().toString())
                .build();
    }
}
