package com.tutorial.springbootelasticsearchelkexample.controller;

import com.tutorial.springbootelasticsearchelkexample.model.Category;
import com.tutorial.springbootelasticsearchelkexample.model.Task;
import com.tutorial.springbootelasticsearchelkexample.model.TaskStatus;
import com.tutorial.springbootelasticsearchelkexample.model.User;
import com.tutorial.springbootelasticsearchelkexample.repository.CategoryRepository;
import com.tutorial.springbootelasticsearchelkexample.repository.TaskRepository;
import com.tutorial.springbootelasticsearchelkexample.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;
    private final CategoryRepository categoryRepository;
    private final TaskRepository taskRepository;

    @PostConstruct
    public void init(){
        Category category1 = new Category();
        category1.setId(UUID.randomUUID());
        category1.setName("Shopping");

        Category category2 = new Category();
        category2.setId(UUID.randomUUID());
        category2.setName("Working");

        categoryRepository.save(category1);
        categoryRepository.save(category2);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<User>> getUsersByName(@PathVariable("search") String name) {
        return ResponseEntity.ok(userService.getUsersByName(name));
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{taskId}/{userId}")
    public void takeTask(@PathVariable("taskId") int taskId, @PathVariable("userId") int userId) {
        userService.takeTask(taskId, userId);
    }


    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{taskId}/{userId}/{status}")
    public void updateTask(@PathVariable("taskId") int taskId, @PathVariable("userId") int userId, @PathVariable("status") TaskStatus status) {
        userService.updateTask(taskId, userId,status);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable("id") int id) {
       userService.deleteUser(id);
    }
}
