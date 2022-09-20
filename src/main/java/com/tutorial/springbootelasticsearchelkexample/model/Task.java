package com.tutorial.springbootelasticsearchelkexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Task {

    @Id
    private int id;

    @Field(name = "category", type = FieldType.Object)
    private Category category;

    @Field(name = "text", type = FieldType.Text)
    private String text;

    private TaskStatus status = TaskStatus.valueOf("TODO");
}
