package com.example.demo.service;

import com.example.demo.dao.AuthorDao;
import com.example.demo.dao.PublisherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {
    private final PublisherDao publisherDao;

    @Autowired
    public  PublisherService(@Qualifier("postgresPublisherDao") PublisherDao publisherDao){
        this.publisherDao = publisherDao;
    }


}
