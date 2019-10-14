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


    
}