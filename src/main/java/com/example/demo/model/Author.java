package com.example.demo.model;

public class Author {
    private int id;
    private String name;
    private String description;

    public Author(){}

    public Author(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Author(Author another) {
        this.id = another.id;
        this.name = another.name;
        this.description = another.description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
