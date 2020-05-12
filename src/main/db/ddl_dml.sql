-- DATABASE_URL=postgres://mrk1:qazwsxedc@localhost:5432/simplelib
DROP TABLE IF EXISTS author;

CREATE TABLE author(
    author_id SERIAL,
    author_name VARCHAR(200),
    author_description TEXT,
    PRIMARY KEY(author_id, author_name)
);

INSERT INTO author(author_name, author_description) VALUES('Adam Smith','Iktisatci yazar');

