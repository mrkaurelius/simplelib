package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;

import java.util.List;

@Controller
public class AuthorController {
    private final AuthorService authorService;
    Logger logger = LoggerFactory.getLogger(AuthorController.class);

    // inject actual service to constructor
    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/author")
    public String author(Model model) {
        List<Author> authors = authorService.getAuthors();
        model.addAttribute("authors", authors );
        model.addAttribute("author", new Author() );

        logger.info("/authors " + authors.toString());
        return "/author";
    }

    // TODO how to change post without
    @GetMapping ("/updateauthor")
    public String update(@ModelAttribute Author author, @RequestParam String authorname) {
        // TODO: check sanity
        // fetch user from database and compare
        // have form data do thing
        logger.info("model attr author: " + author.toString());
        logger.info("authorname: " + authorname);

        //todo fetchauthor byname -> updateauthor !!!
        Author oldAuthor = authorService.fetchAuthorByName(authorname);
        if (oldAuthor == null){
            logger.info("cant find any author" + authorname);
            return "redirect:/author";
        } else {
            logger.info(oldAuthor.toString());
        }
        Author updatedAuthor = new Author(oldAuthor);
        if (!author.getName().isEmpty()){
            updatedAuthor.setName(author.getName());
            if (!author.getDescription().isEmpty())
                updatedAuthor.setDescription(updatedAuthor.getDescription());
            authorService.updateAuthor(oldAuthor, updatedAuthor);
            return "redirect:/author";
        }

        logger.info("no change has been made");
        return "redirect:/author";
    }

    @PostMapping("/addauthor")
    public String addAuthor(@ModelAttribute Author author) {
        // TODO: check sanity
        // have form data do thing
        authorService.addAuthor(author);
        return "redirect:/author";
    }

    @PostMapping("/deleteauthor")
    public String deleteAuthor(@ModelAttribute Author author) {
        // TODO: check sanity
        // have form data do thing
        authorService.deleteAuthorByName(author.getName());
        return "redirect:/author";
    }
}
