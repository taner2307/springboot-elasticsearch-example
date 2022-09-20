package com.tutorial.springbootelasticsearchelkexample.service;

import com.tutorial.springbootelasticsearchelkexample.model.Task;
import com.tutorial.springbootelasticsearchelkexample.model.TaskStatus;
import com.tutorial.springbootelasticsearchelkexample.model.User;

import java.util.List;

public interface IUserService {

    User saveUser(User user);
    List<User> getUsersByName(String name);
    void deleteUser(int id);
    void takeTask(int taskId, int userId);
    void updateTask(int taskId, int userId, TaskStatus status);
}
