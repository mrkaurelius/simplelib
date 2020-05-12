package com.example.demo.service;

import com.example.demo.dao.AuthorDao;
import com.example.demo.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

// TODO update

@Service
public class AuthorService {
    private final AuthorDao authorDao;

    // author dao injected not directy generated by this class
    // qualifier for different implementations of interface
    @Autowired
    public  AuthorService(@Qualifier("postgresAuthorDao") AuthorDao authorDao){
        this.authorDao = authorDao;
    }

    public List<Author> getAuthors(){
        return authorDao.getAuthors();
    }

    public int addAuthor(Author author){
        return authorDao.addAuthor(author);
    }

    public int deleteAuthorByName(String authorName){
        return authorDao.deleteAuthorByName(authorName);
    }

    public int updateAuthorByName(String authorName, Author updatedAuthor){
        return authorDao.updateAuthorByName(authorName, updatedAuthor);
    }

    public int updateAuthor(Author author, Author updatedAuthor){
        return authorDao.updateAuthor(author, updatedAuthor);
    }

    public Author fetchAuthorByName(String authorName){
        return authorDao.fetchAuthorByName(authorName);
    }

}
