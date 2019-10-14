package com.example.controllers;

public class ExampleRequestDto {

    private String id;
    private String name;
    private String changedFieldName;
    private Integer age;

    public ExampleRequestDto() {
    }

    public String getChangedFieldName() {
        return changedFieldName;
    }

    public void setChangedFieldName(String changedFieldName) {
        this.changedFieldName = changedFieldName;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}