package com.tutorial.springbootelasticsearchelkexample.repository;

import com.tutorial.springbootelasticsearchelkexample.model.User;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UserRepository extends ElasticsearchRepository<User, Integer> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    List<User> getUsersByName(String name);
}
