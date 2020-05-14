package com.example.demo.service;

import com.example.demo.dao.AuthorDao;
import com.example.demo.dao.BookDao;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookDao bookDao;


    @Autowired
    public  BookService(@Qualifier("postgresBookDao") BookDao bookDao){
        this.bookDao = bookDao;
    }

    public List<Book> getBooks(){
        return bookDao.getBooks();
    }

    public int addBook(Book book){
        return bookDao.addBook(book);
    }


    public int updateBook(Book book, Book updatedBook){
        return bookDao.updateBook(book, updatedBook);
    }

    public Book fetchBookByISBN(String ISBN){
        return bookDao.fetchBookByISBN(ISBN);
    }

    public Book fetchBookByName(String bookName){
        return bookDao.fetchBookByName(bookName);
    }

    public int deleteBookByISBN(String ISBN){
        return bookDao.deleteBookByISBN(ISBN);
    }

}
