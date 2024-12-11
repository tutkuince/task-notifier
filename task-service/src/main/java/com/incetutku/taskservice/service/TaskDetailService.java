package com.incetutku.taskservice.service;

import com.incetutku.taskservice.dto.TaskDTO;
import com.incetutku.taskservice.dto.TaskDetailDTO;

import java.util.List;

public interface TaskDetailService {
    TaskDetailDTO save(TaskDTO taskDTO);

    TaskDetailDTO getTaskDetailById(String id);

    List<TaskDetailDTO> getWithContainTaskDescription(String taskDescription);

    List<TaskDetailDTO> getWithContainTaskTitle(String taskTitle);

    List<TaskDetailDTO> getAllTaskDetails();

    TaskDetailDTO updateTaskDetail(TaskDetailDTO taskDetailDTO);

    TaskDetailDTO deleteTaskDetailById(String id);
}
