package com.example.demo.dao;

import com.example.demo.model.Author;

import java.util.List;

public interface AuthorDao {
    // add author with pregenerated id
    int addAuthor(Author author);
    int deleteAuthor(Author author);
    int deleteAuthorByName(String authorName);
    int updateAuthor(Author author, Author updatedAuthor);
    int updateAuthorByName(String authorName, Author updatedAuthor);
    int updateAuthorById(int id, Author updatedAuthor);
    Author fetchAuthorByName(String authorName);

    List<Author> getAuthors();
}
