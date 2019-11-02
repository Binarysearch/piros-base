package com.example.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.example.services.ExampleService;

import org.piros.api.Controller;
import org.piros.api.WsController;
import org.piros.injection.Injected;
import org.piros.model.session.Session;
import org.piros.api.servlet.ApiRequest;

public class ExampleController {

    @Injected
    private ExampleService exampleService;


    @WsController("example")
    public List<ExampleDto> test(ExampleRequestDto dto, Session session) {
        exampleService.create(dto.getName(), dto.getAge());

        return exampleService.getAll().stream().map(
            e -> new ExampleDto(e.getId(), e.getEntityName(), e.getAge())
        ).collect(Collectors.toList());
        
    }

    @Controller("/delete-example")
    public List<ExampleDto> delete(String id, ApiRequest request) {

        exampleService.delete(id);

        return exampleService.getAll().stream().map(
            e -> new ExampleDto(e.getId(), e.getEntityName(), e.getAge())
        ).collect(Collectors.toList());
        
    }


}