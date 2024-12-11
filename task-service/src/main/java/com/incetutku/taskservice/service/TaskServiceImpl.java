package com.incetutku.taskservice.service;

import com.incetutku.taskservice.dto.TaskDTO;
import com.incetutku.taskservice.entity.Task;
import com.incetutku.taskservice.mapper.TaskMapper;
import com.incetutku.taskservice.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public TaskDTO save(TaskDTO taskDTO) {
        return null;
    }

    @Override
    public TaskDTO update(String id, TaskDTO taskDTO) {
        return null;
    }

    @Override
    public TaskDTO getTaskById(String id) {
        Task selectedTask = taskRepository.findById(id).orElseThrow(IllegalAccessError::new);
        return TaskMapper.mapToTaskDTO(selectedTask);
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        return List.of();
    }

    @Override
    public Page<TaskDTO> getPagination(int pageSize, int pageNo) {
        return null;
    }

    @Override
    public TaskDTO deleteTaskById(String id) {
        return null;
    }
}
