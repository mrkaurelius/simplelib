package com.example.demo.dao;

import com.example.demo.model.Publisher;
import com.example.demo.model.Publisher;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("postgresPublisherDao")
public class PublisherDataAccessService implements  PublisherDao{

    NamedParameterJdbcTemplate template;

    public PublisherDataAccessService(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public int addPublisher(Publisher publisher) {
        int ret = template.
                getJdbcTemplate().
                update("INSERT INTO publisher(publisher_name, publisher_description) VALUES(?,?)",
                        publisher.getName(), publisher.getDescription());
        return ret;
    }

    @Override
    public List<Publisher> getPublishers() {
        return template.
                getJdbcTemplate().
                query("SELECT * FROM publisher",mapPublisher);
    }

    @Override
    public int deletePublisherByName(String publisherName) {
        int ret = template.
                getJdbcTemplate().
                update("DELETE FROM publisher where publisher_name = ?", publisherName);
        return ret;
    }

    @Override
    public int updatePublisher(Publisher publisher, Publisher updatedPublisher) {
        int ret = template.
                getJdbcTemplate().
                update("UPDATE publisher SET publisher_name = ?, publisher_description = ? WHERE publisher_id = ?",
                        updatedPublisher.getName(), updatedPublisher.getDescription(), publisher.getId());
        return ret;
    }

    @Override
    public Publisher fetchPublisherByName(String publisherName) {

        try {
            return template.getJdbcTemplate().queryForObject("SELECT * FROM publisher WHERE publisher_name  = ? ",mapPublisher,publisherName);
        } catch (Exception e) {
            return  null;
        }
    }

    // todo change this !!!
    RowMapper<Publisher> mapPublisher = (rs, rowNum) -> {
        Publisher p = new Publisher();
        p.setId(rs.getInt("publisher_id"));
        p.setName(rs.getString("publisher_name"));
        p.setDescription(rs.getString("publisher_description"));
        return p;
    };

}
