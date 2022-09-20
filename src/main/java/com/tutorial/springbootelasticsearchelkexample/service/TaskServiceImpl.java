package com.tutorial.springbootelasticsearchelkexample.service;

import com.tutorial.springbootelasticsearchelkexample.model.Task;
import com.tutorial.springbootelasticsearchelkexample.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements ITaskService {

    private final TaskRepository taskRepository;

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }
}
