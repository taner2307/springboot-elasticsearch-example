package com.tutorial.springbootelasticsearchelkexample.repository;

import com.tutorial.springbootelasticsearchelkexample.model.Task;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TaskRepository extends ElasticsearchRepository<Task, Integer> {
}
