package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Controller
public class AuthorController {

    private final AuthorService authorService;

    // inject actual service to constructor
    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/author")
    public String authorForm(Model model) {
        //Author dummyAuthor = new Author(UUID.randomUUID(),"Adam Smith", "Ahlak Felsefecisi");
        model.addAttribute("author", new Author());

        /*
        System.out.println("Authors ");
        List<Author> fakeDB = authorService.getAuthors();
        for (int i = 0; i < fakeDB.size(); i++) {
            System.out.println(fakeDB.get(i).toString());
        }
        */

        return "author";
    }

    @PostMapping ("/editauthor")
    public String editAuthor(@ModelAttribute Author author) {
        // TODO: check sanity
        // fetch user from database and compare
        // have form data do thing

        System.out.println(author.toString());
        return "author";
    }

    @PostMapping("/addauthor")
    public String addAuthor(@ModelAttribute Author author) {
        // TODO: check sanity
        // have form data do thing
        author.setId(UUID.randomUUID());

        //authorService.addAuthor(author);
        // System.out.println(author.toString());
        return "author";
    }
}
