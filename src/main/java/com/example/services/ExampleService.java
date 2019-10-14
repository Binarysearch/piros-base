package com.example.services;

import java.util.List;

import com.example.controllers.ExampleEntity;

public interface ExampleService {

	public void create(String id, String name, String changedFieldName, Integer age);

    public List<ExampleEntity> getAll();

	public void delete(String id);

}