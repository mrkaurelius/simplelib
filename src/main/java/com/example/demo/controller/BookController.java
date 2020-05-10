package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    @RequestMapping(value = "/book")
    public String home() {
        return "book";
    }
}
