package com.example.demo.controller;


import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    Logger logger = LoggerFactory.getLogger(HomeController.class);
    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public HomeController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @GetMapping(value = "/")
    public String home() {
        return "home";
    }


    @GetMapping ("/queryauthor")
    public String queryauthor(Model model, @RequestParam String authorname) {
        logger.info("/queryauthor");
        logger.info(authorname);

        Author a = authorService.fetchAuthorByName(authorname);
        //System.out.println(a.toString());
        model.addAttribute("authors", a);

        return "authorresult";
    }


    @GetMapping ("/querybook")
    public String querybook(Model model, @RequestParam String bookname) {
        logger.info("/querybook");
        logger.info(bookname);

        Book b = bookService.fetchBookByName(bookname);
        model.addAttribute("books", b);
        //System.out.println(b);

        return "bookresult";
    }

    @GetMapping ("/queryseries")
    public String queryserires(Model model, @RequestParam String seriesname) {
        logger.info("/queryseries");
        logger.info(seriesname);
        List<Book> books = bookService.getBooks();
        List<Book> seriesBooks = new ArrayList<>();

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getSeriesName().equals(seriesname))
                seriesBooks.add(books.get(i));
        }
        model.addAttribute("books", seriesBooks);

        //System.out.println(seriesBooks.toString());
        return "bookresult";
    }

    @GetMapping ("/queryisbn")
    public String queryisbn(Model model, @RequestParam String bookisbn) {
        logger.info("/queryisbn");
        logger.info(bookisbn);

        Book b = bookService.fetchBookByISBN(bookisbn);
        model.addAttribute("books", b);

        //System.out.println(b);
        return "bookresult";
    }
}