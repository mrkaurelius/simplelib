package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublisherController {
    @RequestMapping(value = "/publisher")
    public String home() {
        return "publisher";
    }
}
