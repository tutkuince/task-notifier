package com.incetutku.taskservice.service;

import com.incetutku.taskservice.dto.TaskDTO;
import com.incetutku.taskservice.entity.PriorityType;
import com.incetutku.taskservice.entity.Status;
import com.incetutku.taskservice.entity.Task;
import com.incetutku.taskservice.mapper.TaskMapper;
import com.incetutku.taskservice.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public TaskDTO update(TaskDTO taskDTO) {
        Task task = taskRepository.findById(taskDTO.getId()).orElseThrow(IllegalAccessError::new);
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setNotes(taskDTO.getNotes());
        task.setAssignee(taskDTO.getAssignee());
        task.setStartDate(taskDTO.getStartDate());
        task.setStatus(Status.valueOf(taskDTO.getStatus()));
        task.setPriorityType(PriorityType.valueOf(taskDTO.getPriorityType()));

        taskRepository.save(task);
        return taskDTO;
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
        TaskDTO taskById = getTaskById(id);
        taskRepository.deleteById(id);
        return taskById;
    }
}
