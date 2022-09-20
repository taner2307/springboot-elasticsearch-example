package com.tutorial.springbootelasticsearchelkexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Document(indexName = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    private int id;

    @Field(name = "name", type = FieldType.Text)
    private String name;

    @Field(name = "tasks", type = FieldType.Object)
    private List<Task> tasks;

}
