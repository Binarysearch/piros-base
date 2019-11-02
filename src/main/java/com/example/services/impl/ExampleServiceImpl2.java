package com.example.services.impl;

import java.util.List;

import com.example.controllers.ExampleEntity;
import com.example.services.ExampleService;

import org.piros.injection.Injectable;
import org.piros.injection.Injected;
import org.piros.services.IdService;
import org.piros.injection.Default;
import org.piros.data.services.DatabaseService;

@Injectable
@Default
public class ExampleServiceImpl2 implements ExampleService {

    @Injected
    private DatabaseService ds;

    @Injected
    private IdService idService;
    
    @Override
    public void create(String name, Integer age) {
        ds.insert(new ExampleEntity(idService.generate(), name, age));
    }

    @Override
    public List<ExampleEntity> getAll() {
        return ds.execute("select * from example_entity", ExampleEntity.class);
    }

    @Override
    public void delete(String id) {
        this.ds.delete(ExampleEntity.class, id);
    }
    
}