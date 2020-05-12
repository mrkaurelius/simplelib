package com.example.demo.dao;

import com.example.demo.model.Author;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

// TODO: connect postgres db
@Repository("postgresAuthorDao")
public class AuthorDataAccessService implements AuthorDao{

    NamedParameterJdbcTemplate template;

    public AuthorDataAccessService(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public int addAuthor(Author author) {
        int ret = template.
                getJdbcTemplate().
                update("INSERT INTO author(author_name, author_description) VALUES(?,?)",
                        author.getName(), author.getDescription());
        return ret;
    }

    @Override
    public List<Author> getAuthors() {
        return template.
                getJdbcTemplate().
                query("SELECT * FROM author",mapAuthor);
    }

    @Override
    public int deleteAuthor(Author author) {
        int ret = template.
                getJdbcTemplate().
                update("DELETE FROM author where author_id = ?", author.getId());
        return ret;
    }

    @Override
    public int deleteAuthorByName(String authorName) {
        int ret = template.
                getJdbcTemplate().
                update("DELETE FROM author where author_name = ?", authorName);
        return ret;
    }

    @Override
    public int updateAuthor(Author author, Author updatedAuthor) {
        int ret = template.
                getJdbcTemplate().
                update("UPDATE author SET author_name = ?, author_description = ? WHERE author_id = ?",
                        updatedAuthor.getName(), updatedAuthor.getDescription(), author.getId());
        return ret;
    }

    @Override
    public int updateAuthorByName(String authorName, Author updatedAuthor) {
        int ret = template.
                getJdbcTemplate().
                update("UPDATE author SET author_name = ?, author_description = ? WHERE author_name = ?",
                        updatedAuthor.getName(), updatedAuthor.getDescription(), authorName);
        return ret;
    }

    @Override
    public int updateAuthorById(int id, Author updatedAuthor) {
        int ret = template.
                getJdbcTemplate().
                update("UPDATE author SET author_name = ?, author_description = ? WHERE author_id = ?",
                        updatedAuthor.getName(), updatedAuthor.getDescription(), id);
        return ret;
    }

    @Override
    public Author fetchAuthorByName(String authorName) {

        try {
            return template.getJdbcTemplate().queryForObject("SELECT * FROM author WHERE author_name  = ? ",mapAuthor,authorName);
        } catch (Exception e) {
            return  null;
        }
    }

    RowMapper<Author> mapAuthor = (rs, rowNum) -> {
        Author a = new Author();
        a.setId(rs.getInt("author_id"));
        a.setName(rs.getString("author_name"));
        a.setDescription(rs.getString("author_description"));
        return a;
    };
}
