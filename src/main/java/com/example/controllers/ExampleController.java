package com.example.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.example.services.ExampleService;

import org.piros.api.Controller;
import org.piros.injection.Injected;
import org.piros.api.servlet.ApiRequest;

public class ExampleController {

    @Injected
    private ExampleService exampleService;


    @Controller("/example")
    public List<ExampleDto> test(ExampleRequestDto dto, ApiRequest request) {

        exampleService.create(dto.getId(), dto.getName(), dto.getChangedFieldName(), dto.getAge());

        return exampleService.getAll().stream().map(
            e -> new ExampleDto(e.getId(), e.getEntityName(), e.getChangedFieldName(), e.getAge())
        ).collect(Collectors.toList());
        
    }

    @Controller("/delete-example")
    public List<ExampleDto> delete(String id, ApiRequest request) {

        exampleService.delete(id);

        return exampleService.getAll().stream().map(
            e -> new ExampleDto(e.getId(), e.getEntityName(), e.getChangedFieldName(), e.getAge())
        ).collect(Collectors.toList());
        
    }


}