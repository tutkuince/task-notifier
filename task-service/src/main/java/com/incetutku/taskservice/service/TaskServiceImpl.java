package com.incetutku.taskservice.service;

import com.incetutku.taskservice.dto.TaskDTO;
import com.incetutku.taskservice.entity.Task;
import com.incetutku.taskservice.mapper.TaskMapper;
import com.incetutku.taskservice.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public TaskDTO save(TaskDTO taskDTO) {
        Task savableTask = TaskMapper.mapToTask(taskDTO);
        Task savedTask = taskRepository.save(savableTask);
        return TaskMapper.mapToTaskDTO(savedTask);
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
        List<Task> taskList = taskRepository.findAll();
        return taskList.stream().map(TaskMapper::mapToTaskDTO).toList();
    }

    @Override
    public List<TaskDTO> getPagination(int pageNumber, int pageSize) {
        Page<Task> tasks = taskRepository.findAll(PageRequest.of(pageNumber, pageSize));
        return tasks.stream().map(TaskMapper::mapToTaskDTO).toList();
    }

    @Override
    public TaskDTO deleteTaskById(String id) {
        return null;
    }
}
