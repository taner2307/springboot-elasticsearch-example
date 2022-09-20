package com.tutorial.springbootelasticsearchelkexample.repository;

import com.tutorial.springbootelasticsearchelkexample.model.Category;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import java.util.UUID;

public interface CategoryRepository extends ElasticsearchRepository<Category, UUID> {

}
