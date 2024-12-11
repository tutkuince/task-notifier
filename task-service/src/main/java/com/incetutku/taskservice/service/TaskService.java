package com.incetutku.taskservice.service;

import com.incetutku.taskservice.dto.TaskDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TaskService {

    TaskDTO save(TaskDTO taskDTO);

    TaskDTO update(String id, TaskDTO taskDTO);

    TaskDTO getTaskById(String id);

    List<TaskDTO> getAllTasks();

    Page<TaskDTO> getPagination(int pageSize, int pageNo);

    TaskDTO deleteTaskById(String id);
}