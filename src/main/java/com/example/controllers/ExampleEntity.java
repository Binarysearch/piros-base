package com.example.controllers;

import org.piros.data.Id;
import org.piros.data.Table;

@Table()
public class ExampleEntity {

    @Id
    private String id;
    private String entityName;
    
    private Integer age;

    public ExampleEntity() {
    }

    public ExampleEntity(String id, String entityName, Integer age) {
        this.id = id;
        this.entityName = entityName;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    
}