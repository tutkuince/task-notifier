package com.incetutku.taskservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.incetutku.taskservice.dto.TaskDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TaskService {

    TaskDTO save(TaskDTO taskDTO) throws JsonProcessingException;

    TaskDTO update(TaskDTO taskDTO);

    TaskDTO getTaskById(String id);

    List<TaskDTO> getAllTasks();

    List<TaskDTO> getPagination(int pageNumber, int pageSize);

    TaskDTO deleteTaskById(String id);
}
