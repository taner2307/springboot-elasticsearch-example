package com.tutorial.springbootelasticsearchelkexample.service;

import com.tutorial.springbootelasticsearchelkexample.model.Task;

public interface ITaskService {

    Task saveTask(Task task);

    void deleteTask(int id);
}
