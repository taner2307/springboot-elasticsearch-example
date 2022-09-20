package com.tutorial.springbootelasticsearchelkexample.service;

import com.tutorial.springbootelasticsearchelkexample.model.Task;
import com.tutorial.springbootelasticsearchelkexample.model.TaskStatus;
import com.tutorial.springbootelasticsearchelkexample.model.User;
import com.tutorial.springbootelasticsearchelkexample.repository.TaskRepository;
import com.tutorial.springbootelasticsearchelkexample.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService{

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsersByName(String name) {
        return userRepository.getUsersByName(name);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void takeTask(int taskId, int userId) {
        List<Task> tasks = new ArrayList<>();
        Task task1 = taskRepository.findById(taskId).orElseThrow(
                () -> new ResourceNotFoundException("Task not found " + taskId));
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User not found " + userId));
        if (task1.getStatus() == TaskStatus.TODO) {
            task1.setStatus(TaskStatus.IN_PROGRESS);
            tasks.add(task1);
            user.setTasks(tasks);

            userRepository.save(user);
            taskRepository.save(task1);
        } else {
            throw new IllegalStateException("Task is not available");
        }
    }

    @Transactional
    @Override
    public void updateTask(int taskId, int userId, TaskStatus status) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User not found " + userId));
        user.getTasks().stream().forEach(t->{
            if (t.getId() == taskId) {
                t.setStatus(status);
                taskRepository.save(t);
            }
        });
        userRepository.save(user);
    }
}
