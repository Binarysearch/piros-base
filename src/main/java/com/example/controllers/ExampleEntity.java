package com.example.controllers;

import org.piros.data.Column;
import org.piros.data.Id;
import org.piros.data.Table;

@Table()
public class ExampleEntity {

    @Id
    private String id;
    private String entityName;

    @Column("other_field_name")
    private String changedFieldName;
    
    private Integer age;

    public ExampleEntity() {
    }

    public ExampleEntity(String id, String entityName, String changedFieldName, Integer age) {
        this.id = id;
        this.entityName = entityName;
        this.changedFieldName = changedFieldName;
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

    public String getChangedFieldName() {
        return changedFieldName;
    }

    public void setChangedFieldName(String changedFieldName) {
        this.changedFieldName = changedFieldName;
    }


    
}