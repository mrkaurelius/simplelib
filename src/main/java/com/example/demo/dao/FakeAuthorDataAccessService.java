package com.example.demo.dao;

import com.example.demo.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakeAuthorDataAccessService implements AuthorDao {

    private  static List<Author> DB = new ArrayList<>();

    @Override
    public int insertAuthor(UUID id, Author author) {
        Author newAuthor =  author;
        author.setId(id);
        DB.add(author);
        return 1;
    }

    @Override
    public List<Author> getAuthors() {
        List<Author> db = DB;
        return db;
    }
}
