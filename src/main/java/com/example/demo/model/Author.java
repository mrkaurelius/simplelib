package com.example.demo.model;

import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;

import java.util.UUID;

public class Author {
    private UUID id;
    private String name;
    private String description;

    public Author(){}

    public Author(UUID id, String name, String explanation) {
        this.id = id;
        this.name = name;
        this.description = explanation;
    }

    public Author(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", explanation='" + description + '\'' +
                '}';
    }
}
