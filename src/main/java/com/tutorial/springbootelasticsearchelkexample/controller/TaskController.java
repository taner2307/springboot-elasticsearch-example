package com.tutorial.springbootelasticsearchelkexample.controller;

import com.tutorial.springbootelasticsearchelkexample.model.Category;
import com.tutorial.springbootelasticsearchelkexample.model.Task;
import com.tutorial.springbootelasticsearchelkexample.model.User;
import com.tutorial.springbootelasticsearchelkexample.repository.CategoryRepository;
import com.tutorial.springbootelasticsearchelkexample.repository.TaskRepository;
import com.tutorial.springbootelasticsearchelkexample.service.ITaskService;
import com.tutorial.springbootelasticsearchelkexample.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final ITaskService taskService;


    @PostMapping
    public ResponseEntity<Task> saveTask(@RequestBody Task task) {
        return new ResponseEntity<>(taskService.saveTask(task), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTask(@PathVariable("id") int id) {
       taskService.deleteTask(id);
    }
}
