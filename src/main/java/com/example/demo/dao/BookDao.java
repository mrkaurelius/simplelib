package com.example.demo.dao;

import com.example.demo.model.Book;

import java.util.List;

public interface BookDao {
    int addBook(Book book);
    int deleteBookByISBN(String bookISBN);
    int updateBook(Book book, Book updatedBook);
    Book fetchBookByISBN(String bookISBN);
    Book fetchBookByName(String bookName);
    List<Book> getBooks();
}
