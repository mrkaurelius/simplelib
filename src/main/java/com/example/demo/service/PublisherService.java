package com.example.demo.service;

import com.example.demo.dao.PublisherDao;
import com.example.demo.dao.PublisherDao;
import com.example.demo.model.Publisher;
import com.example.demo.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {
    private final PublisherDao publisherDao;

    @Autowired
    public  PublisherService(@Qualifier("postgresPublisherDao") PublisherDao publisherDao){
        this.publisherDao = publisherDao;
    }

    public List<Publisher> getPublishers(){ return publisherDao.getPublishers(); }

    public int addPublisher(Publisher publisher) {return publisherDao.addPublisher(publisher); }

    public int deletePublisherByName(String publisherName){
        return publisherDao.deletePublisherByName(publisherName);
    }

    public int updatePublisher(Publisher publisher, Publisher updatedPublisher){
        return publisherDao.updatePublisher(publisher, updatedPublisher);
    }

    public Publisher fetchPublisherByName(String publisherName){
        return publisherDao.fetchPublisherByName(publisherName);
    }
}
