package com.incetutku.taskservice.repository;

import com.incetutku.taskservice.entity.TaskDetail;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface TaskDetailRepository extends ElasticsearchRepository<TaskDetail, String> {
    List<TaskDetail> findByTaskDescriptionContains(String taskDescription);
    List<TaskDetail> findByTaskTitleContains(String taskTitle);
    List<TaskDetail> findByEmployeeNameStartingWith(String employeeName);
}
