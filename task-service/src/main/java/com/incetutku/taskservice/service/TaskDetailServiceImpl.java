package com.incetutku.taskservice.service;

import com.incetutku.taskservice.dto.TaskDTO;
import com.incetutku.taskservice.dto.TaskDetailDTO;
import com.incetutku.taskservice.entity.TaskDetail;
import com.incetutku.taskservice.mapper.TaskDetailMapper;
import com.incetutku.taskservice.repository.TaskDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskDetailServiceImpl implements TaskDetailService {

    private final TaskDetailRepository taskDetailRepository;

    @Override
    public TaskDetailDTO save(TaskDetailDTO taskDetailDTO) {
        TaskDetail savableTask = TaskDetailMapper.mapToTaskDetail(taskDetailDTO);
        TaskDetail savedTaskDetail = taskDetailRepository.save(savableTask);
        return TaskDetailMapper.mapToTaskDetailDTO(savedTaskDetail);
    }

    @Override
    public TaskDetailDTO getTaskDetailById(String id) {
        TaskDetail selectedTaskDetail = taskDetailRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return TaskDetailMapper.mapToTaskDetailDTO(selectedTaskDetail);
    }

    @Override
    public List<TaskDetailDTO> getWithContainTaskDescription(String taskDescription) {
        return List.of();
    }

    @Override
    public List<TaskDetailDTO> getWithContainTaskTitle(String taskTitle) {
        return List.of();
    }

    @Override
    public List<TaskDetailDTO> getAllTaskDetails() {
        List<TaskDetail> taskDetailList = new ArrayList<>();
        Iterable<TaskDetail> taskDetails = taskDetailRepository.findAll();
        taskDetails.forEach(taskDetailList::add);
        return taskDetailList.stream().map(TaskDetailMapper::mapToTaskDetailDTO).toList();
    }

    @Override
    public TaskDetailDTO updateTaskDetail(TaskDetailDTO taskDetailDTO) {
        return null;
    }

    @Override
    public TaskDetailDTO deleteTaskDetailById(String id) {
        return null;
    }
}
