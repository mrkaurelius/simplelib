package com.example.demo.dao;

import com.example.demo.model.Publisher;

import java.util.List;

public interface PublisherDao {

    int addPublisher(Publisher Publisher);
    int deletePublisherByName(String PublisherName);

    int updatePublisher(Publisher Publisher, Publisher updatedPublisher);
    Publisher fetchPublisherByName(String PublisherName);

    List<Publisher> getPublishers();
}
