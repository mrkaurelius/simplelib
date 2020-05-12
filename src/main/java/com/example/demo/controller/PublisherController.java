package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.model.Publisher;
import com.example.demo.service.PublisherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PublisherController {
    private final PublisherService publisherService;
    Logger logger = LoggerFactory.getLogger(PublisherController.class);

    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("/publisher")
    public String author(Model model) {
        //List<Author> authors = authorService.getAuthors();
        //model.addAttribute("authors", authors );
        model.addAttribute("publisher", new Publisher());

        //todo do publisher test here

        //logger.info("/publishers " + publishers.toString());
        return "/publisher";
    }

    // TODO how to change post without
    @GetMapping ("/updatepublisher")
    public String update(@ModelAttribute Publisher publisher, @RequestParam String publishername) {
        // TODO: check sanity
        // fetch user from database and compare
        // have form data do thing
        logger.info("model attr author: " + publisher.toString());
        logger.info("authorname: " + publishername);

        //todo  author -> publisher !!!
        /*
        Author oldAuthor = authorService.fetchAuthorByName(authorname);
        if (oldAuthor == null){
            logger.info("cant find any author" + authorname);
            return "redirect:/author";
        } else {
            logger.info(oldAuthor.toString());
        }
        Author updatedAuthor = new Author(oldAuthor);
        if (!author.getDescription().isEmpty() && !author.getName().isEmpty()){
            updatedAuthor.setName(author.getName());
            updatedAuthor.setDescription(author.getDescription());
            authorService.updateAuthor(oldAuthor, updatedAuthor);
            return "redirect:/author";
        }
        */

        logger.info("no change been made");
        return "redirect:/author";
    }

    @PostMapping("/addpublisher")
    public String addAuthor(@ModelAttribute Publisher publisher) {
        // TODO: check sanity
        // have form data do thing
        //authorService.addAuthor(author);
        logger.info(publisher.toString());
        return "redirect:/publisher";
    }

    @PostMapping("/deletepublisher")
    public String deleteAuthor(@ModelAttribute Publisher publisher) {
        // TODO: check sanity
        // have form data do thing
        //authorService.deleteAuthorByName(author.getName());
        logger.info(publisher.toString());
        return "redirect:/publisher";
    }
}
