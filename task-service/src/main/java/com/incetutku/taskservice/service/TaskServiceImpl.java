package com.incetutku.taskservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.incetutku.taskservice.dto.EmployeeDTO;
import com.incetutku.taskservice.dto.TaskDTO;
import com.incetutku.taskservice.dto.TaskDetailDTO;
import com.incetutku.taskservice.dto.TaskNotificationDTO;
import com.incetutku.taskservice.entity.PriorityType;
import com.incetutku.taskservice.entity.Status;
import com.incetutku.taskservice.entity.Task;
import com.incetutku.taskservice.mapper.TaskMapper;
import com.incetutku.taskservice.producer.TaskNotificationProducer;
import com.incetutku.taskservice.repository.TaskRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskDetailService taskDetailService;
    private final APIClient apiClient;
    private final TaskNotificationProducer taskNotificationProducer;

    @Override
    @CircuitBreaker(name = "EMPLOYEE_SERVICE", fallbackMethod = "taskServiceFallbackMethodForDTO")
    public TaskDTO save(TaskDTO taskDTO) throws JsonProcessingException {
        EmployeeDTO employeeDTO = apiClient.getEmployeeById(taskDTO.getAssignee());

        Task savableTask = TaskMapper.mapToTask(taskDTO);
        Task savedTask = taskRepository.save(savableTask);

        taskDTO.setAssignee(employeeDTO.getId());
        taskDTO.setId(savedTask.getId());

        TaskDetailDTO taskDetailDTO = TaskDetailDTO.builder()
                .employeeId(employeeDTO.getId())
                .employeeName(employeeDTO.getName())
                .employeeSurname(employeeDTO.getSurname())
                .taskTitle(taskDTO.getTitle())
                .taskDescription(taskDTO.getDescription())
                .status(taskDTO.getStatus())
                .priority(taskDTO.getPriorityType())
                .build();

        taskDetailService.save(taskDetailDTO);

        TaskNotificationDTO taskNotificationDTO = new TaskNotificationDTO();
        taskNotificationDTO.setTaskId(savedTask.getId());
        taskNotificationDTO.setTaskTitle(savedTask.getTitle());
        taskNotificationDTO.setTaskDescription(savedTask.getDescription());
        taskNotificationDTO.setEmployeeId(employeeDTO.getId());

        taskNotificationProducer.sendToQueue(taskNotificationDTO);

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

    private TaskDTO taskServiceFallbackMethodForDTO(Throwable throwable) {
        TaskDTO dto = new TaskDTO();
        dto.setDescription("This Error Comes from Employee Service for dto");
        System.out.println("This Error Comes from Employee Service for dto");
        return dto;
    }
}
