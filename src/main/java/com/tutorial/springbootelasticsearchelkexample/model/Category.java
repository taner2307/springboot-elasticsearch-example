package com.tutorial.springbootelasticsearchelkexample.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.UUID;

@Document(indexName = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category {

    @Id
    private UUID id;

    @Field(name = "name", type = FieldType.Text)
    private String name;
}
