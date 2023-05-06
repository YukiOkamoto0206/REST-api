CREATE DATABASE library;
use library;

create table patrons (
patron_id bigint primary key, 
name varchar(250) not null );

create table books (
 book_id bigint primary key, 
 title varchar(250) not null, 
 author varchar(250) not null, 
 checkout_patron_id bigint,
 checkout_date date, 
 foreign key (checkout_patron_id) references patrons(patron_id));

INSERT INTO patrons (patron_id, name) VALUES (425198003, 'David');

INSERT INTO books (book_id, title, author, checkout_patron_id, checkout_date) VALUES (981003724, 'Biography of Tom', 'Tom', 425198003, NULL);
INSERT INTO books (book_id, title, author, checkout_patron_id, checkout_date) VALUES (981456123, "All about Mary's Lamb", 'Mary', 425198003, NULL);
