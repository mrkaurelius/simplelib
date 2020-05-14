package com.example.demo.controller;

import com.example.demo.model.Publisher;
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
    public String publisher(Model model) {
        List<Publisher> publishers = publisherService.getPublishers();
        model.addAttribute("publishers", publishers );
        model.addAttribute("publisher", new Publisher());

        logger.info("/publishers " + publishers.toString());
        return "/publisher";
    }

    // TODO how to change post without
    @GetMapping ("/updatepublisher")
    public String update(@ModelAttribute Publisher publisher, @RequestParam String publishername) {
        // TODO: check sanity
        // fetch user from database and compare
        // have form data do thing
        logger.info("model attr publisher: " + publisher.toString());
        logger.info("publishername: " + publishername);

        //todo  publisher -> publisher !!!
        Publisher oldPublisher = publisherService.fetchPublisherByName(publishername);
        if (oldPublisher == null){
            logger.info("cant find any publisher" + publishername);
            return "redirect:/publisher";
        } else {
            logger.info(oldPublisher.toString());
        }
        Publisher updatedPublisher = new Publisher(oldPublisher);
        if (!publisher.getDescription().isEmpty() && !publisher.getName().isEmpty()){
            updatedPublisher.setName(publisher.getName());
            updatedPublisher.setDescription(publisher.getDescription());
            publisherService.updatePublisher(oldPublisher, updatedPublisher);
            return "redirect:/publisher";
        }

        logger.info("no change been made");
        return "redirect:/publisher";
    }

    @PostMapping("/addpublisher")
    public String addPublisher(@ModelAttribute Publisher publisher) {
        // TODO: check sanity
        // have form data do thing
        logger.info("addpublisher");
        publisherService.addPublisher(publisher);
        logger.info(publisher.toString());
        return "redirect:/publisher";
    }

    @PostMapping("/deletepublisher")
    public String deletePublisher(@ModelAttribute Publisher publisher) {
        // TODO: check sanity
        // have form data do thing
        logger.info("deletepublisher");
        publisherService.deletePublisherByName(publisher.getName());
        logger.info(publisher.toString());
        return "redirect:/publisher";
    }
}
