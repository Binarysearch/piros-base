package com.example.controllers;


public class ExampleDto {

    private String id;
    private String name;
    private String changedFieldName;
    private Integer age;

    public ExampleDto() {
    }

    public ExampleDto(String id, String name, String changedFieldName, Integer age) {
        this.id = id;
        this.name = name;
        this.changedFieldName = changedFieldName;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChangedFieldName() {
        return changedFieldName;
    }

    public void setChangedFieldName(String changedFieldName) {
        this.changedFieldName = changedFieldName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    
}