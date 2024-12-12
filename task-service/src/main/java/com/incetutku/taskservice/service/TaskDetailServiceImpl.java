package com.incetutku.taskservice.service;

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
        List<TaskDetail> byTaskDescriptionContains = taskDetailRepository.findByTaskDescriptionContains(taskDescription);
        return byTaskDescriptionContains.stream().map(TaskDetailMapper::mapToTaskDetailDTO).toList();
    }

    @Override
    public List<TaskDetailDTO> getWithContainTaskTitle(String taskTitle) {
        return List.of();
    }

    @Override
    public List<TaskDetailDTO> getWithStartsName(String employeeName) {
        List<TaskDetail> byEmployeeName = taskDetailRepository.findByEmployeeNameStartingWith(employeeName);
        return byEmployeeName.stream().map(TaskDetailMapper::mapToTaskDetailDTO).toList();
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
        TaskDetail selectedTaskDetail = taskDetailRepository.findById(taskDetailDTO.getId()).orElseThrow(IllegalArgumentException::new);
        selectedTaskDetail.setEmployeeId(taskDetailDTO.getEmployeeId());
        selectedTaskDetail.setEmployeeName(taskDetailDTO.getEmployeeName());
        selectedTaskDetail.setEmployeeSurname(taskDetailDTO.getEmployeeSurname());
        selectedTaskDetail.setTaskTitle(taskDetailDTO.getTaskTitle());
        selectedTaskDetail.setTaskDescription(taskDetailDTO.getTaskDescription());
        selectedTaskDetail.setStatus(taskDetailDTO.getStatus());
        selectedTaskDetail.setPriority(taskDetailDTO.getPriority());

        taskDetailRepository.save(selectedTaskDetail);

        return taskDetailDTO;
    }

    @Override
    public TaskDetailDTO deleteTaskDetailById(String id) {
        TaskDetail selectedTaskDetail = taskDetailRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        TaskDetailDTO taskDetailDTO = TaskDetailMapper.mapToTaskDetailDTO(selectedTaskDetail);
        taskDetailRepository.deleteById(id);
        return taskDetailDTO;
    }
}
