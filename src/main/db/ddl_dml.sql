-- DATABASE_URL=postgres://mrk1:qazwsxedc@localhost:5432/simplelib
DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS publisher;
DROP TABLE IF EXISTS book;

CREATE TABLE author(
    author_id SERIAL,
    author_name VARCHAR(200),
    author_description TEXT,
    PRIMARY KEY(author_id, author_name)
);

CREATE TABLE publisher(
    publisher_id SERIAL,
    publisher_name VARCHAR(200),
    publisher_description TEXT,
    PRIMARY KEY(publisher_id, publisher_name)
);

CREATE TABLE book(
    book_id SERIAL,
    book_name VARCHAR(200),
    book_isbn VARCHAR(13),
    book_subname VARCHAR(100),
    book_series_name VARCHAR(100),
    book_description TEXT,
    book_author_name VARCHAR(200),
    book_publisher_name VARCHAR(200),
    PRIMARY KEY(book_isbn)
);

INSERT INTO author(author_name, author_description) 
VALUES('adam smith','iktisatci yazar');

INSERT INTO author(author_name, author_description) 
VALUES('platon','felsefeci');


INSERT INTO publisher(publisher_name, publisher_description) 
VALUES('is bankasi','bir bankanin yayin evi');

INSERT INTO book(book_name ,book_isbn, book_subname, book_series_name, book_description, book_author_name, book_publisher_name)
VALUES('uluslarin zenginligi','9754589276', 'adam smithin klasik iktisat kitabi', 'hasan ali yucel serisi', 'is bankasi hasanali yucel serisinden bir kitap','adam smith', 'is bankasi');

INSERT INTO book(book_name ,book_isbn, book_subname, book_series_name, book_description, book_author_name, book_publisher_name)
VALUES('devlet','9754587173', 'platonun felsefe kitabi', 'hasan ali yucel serisi', 'is bankasi hasanali yucel serisinden bir kitap','platon', 'is bankasi');

select * from author;
select * from publisher;
select * from book;