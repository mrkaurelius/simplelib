/*
INSERT INTO author(author_name, author_description)
 VALUES('Adam Smith','Iktisatci yazar');
 */

UPDATE AUTHOR SET author_name = 'Adam Smith Boyuk', author_description = 'iktisat ve ahlak felsefecisi yazar' WHERE author_id = 1;

SELECT * FROM author;