package com.example.demo.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class QueryDataAccess {
    NamedParameterJdbcTemplate template;
    public QueryDataAccess(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

}
