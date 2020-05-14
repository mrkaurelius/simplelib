package com.example.demo.dao;

import com.example.demo.model.Book;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

// todo
@Repository("postgresBookDao")
public class BookDataAccessService implements BookDao{

    NamedParameterJdbcTemplate template;

    public BookDataAccessService(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public int addBook(Book book) {
        int ret = template.
                getJdbcTemplate().
                update("INSERT INTO book(book_name ,book_isbn, book_subname, book_series_name, book_description, book_author_name, book_publisher_name) VALUES(?,?,?,?,?,?,?)",
                        book.getName(), book.getISBN(), book.getSubName(), book.getSeriesName(), book.getDescription(), book.getAuthorName(), book.getPublisherName());
        return ret;
    }

    @Override
    public int deleteBookByISBN(String bookISBN) {
        int ret = template.
                getJdbcTemplate().
                update("DELETE FROM book WHERE book_isbn = ?", bookISBN);
        return ret;
    }

    /*
    book_id
    book_name
    book_isbn
    book_subname
    book_series_name
    book_description
    book_author_name
    book_publisher_name
    */
    @Override
    public int updateBook(Book b, Book ub) {
        // book updatedbook
        // todo burada kaldim
        int ret = template.
                getJdbcTemplate().
                update("UPDATE book SET " +
                        "book_id = ?, book_name = ?, " +
                        "book_isbn = ?, book_subname = ?, " +
                        "book_series_name = ?, book_description = ?, " +
                        "book_author_name = ?, book_publisher_name = ?" +
                        "WHERE book_isbn = ?", ub.getId(), ub.getName(), ub.getISBN(), ub.getSubName(),
                        ub.getSeriesName(), ub.getDescription(), ub.getAuthorName(), ub.getPublisherName(),
                        b.getISBN());
        return ret;
    }

    @Override
    public Book fetchBookByISBN(String bookISBN) {
        try {
            return template.getJdbcTemplate().queryForObject("SELECT * FROM book WHERE book_isbn = ? ",mapBook, bookISBN);
        } catch (Exception e) {
            return  null;
        }
    }

    @Override
    public List<Book> getBooks() {
        return template.
                getJdbcTemplate().
                query("SELECT * FROM book",mapBook);
    }

    @Override
    public Book fetchBookByName(String bookName) {
        try {
            return template.getJdbcTemplate().queryForObject("SELECT * FROM book WHERE book_name = ? ",mapBook, bookName);
        } catch (Exception e) {
            return  null;
        }
    }

    RowMapper<Book> mapBook = (rs, rowNum) -> {
        Book b = new Book();
        b.setId(rs.getInt("book_id"));
        b.setName(rs.getString("book_name"));
        b.setISBN(rs.getString("book_isbn"));
        b.setSubName(rs.getString("book_subname"));
        b.setSeriesName(rs.getString("book_series_name"));
        b.setDescription(rs.getString("book_description"));
        b.setAuthorName(rs.getString("book_author_name"));
        b.setPublisherName(rs.getString("book_publisher_name"));
        return b;
    };
}

