package com.example.demo.dao;

import com.example.demo.model.Author;
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
    public int addPublisher(Publisher Publisher) {
        return 0;
    }

    @Override
    public int deletePublisherByName(String PublisherName) {
        return 0;
    }

    @Override
    public int updatePublisher(Publisher Publisher, Publisher updatedPublisher) {
        return 0;
    }

    @Override
    public Publisher fetchPublisherByName(String PublisherName) {
        return null;
    }

    @Override
    public List<Publisher> getPublishers() {
        return null;
    }

    // todo change this !!!
    RowMapper<Author> mapAuthor = (rs, rowNum) -> {
        Author a = new Author();
        a.setId(rs.getInt("author_id"));
        a.setName(rs.getString("author_name"));
        a.setDescription(rs.getString("author_description"));
        return a;
    };

}
