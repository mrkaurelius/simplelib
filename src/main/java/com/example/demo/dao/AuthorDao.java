package com.example.demo.dao;

import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;

import java.util.List;
import java.util.UUID;

public interface AuthorDao {
    // add author with pregenerated id
    int insertAuthor(UUID id, Author author);
    List<Author> getAuthors();

    // app author with new random id
    default int insertAuthor(Author author){
        UUID id = UUID.randomUUID();
        return insertAuthor(id, author);
    }

}
