package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    @RequestMapping(value = "/book")
    public String home() {
        return "book";
    }

    private final BookService bookService;

    Logger logger = LoggerFactory.getLogger(BookController.class);

    // inject actual service to constructor
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public String book(Model model) {
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books );
        model.addAttribute("book", new Book() );

        logger.info("/books " + books.toString());
        return "/book";
    }

    // TODO how to change post without
    @GetMapping ("/updatebook")
    public String update(@ModelAttribute Book book, @RequestParam String bookisbn) {
        // TODO: check sanity
        // fetch user from database and compare
        // have form data do thing
        logger.info("model attr book: " + book.toString());
        logger.info("bookisbn: " + bookisbn);

        //todo fetchbook byname -> updatebook !!!
        Book oldBook = bookService.fetchBookByISBN(bookisbn);
        if (oldBook == null){
            logger.info("cant find any book" + bookisbn);
            return "redirect:/book";
        } else {
            logger.info("oldbook" + oldBook.toString());
        }
        Book updatedBook = new Book(oldBook);
        if (!book.getISBN().isEmpty()){
            if (!book.getISBN().isEmpty()) updatedBook.setISBN(book.getISBN());
            if (!book.getName().isEmpty()) updatedBook.setName(book.getName());
            if (!book.getDescription().isEmpty()) updatedBook.setDescription(book.getDescription());
            if (!book.getSubName().isEmpty()) updatedBook.setSubName(book.getSubName());
            if (!book.getSeriesName().isEmpty()) updatedBook.setSeriesName(book.getSeriesName());
            if (!book.getAuthorName().isEmpty()) updatedBook.setAuthorName(book.getAuthorName());
            if (!book.getPublisherName().isEmpty()) updatedBook.setPublisherName(book.getPublisherName());
            bookService.updateBook(oldBook, updatedBook);
            return "redirect:/book";
        }
        logger.info("no change has been made");
        return "redirect:/book";
    }

    @PostMapping("/addbook")
    public String addBook(@ModelAttribute Book book) {
        // TODO: check sanity
        // have form data do thing
        logger.info(book.toString());
        bookService.addBook(book);
        return "redirect:/book";
    }

    @PostMapping("/deletebook")
    public String deleteBook(@ModelAttribute Book book) {
        // TODO: check sanity
        // have form data do thing
        logger.info("/deletebook " + book.toString());
        bookService.deleteBookByISBN(book.getISBN());
        return "redirect:/book";
    }
}
