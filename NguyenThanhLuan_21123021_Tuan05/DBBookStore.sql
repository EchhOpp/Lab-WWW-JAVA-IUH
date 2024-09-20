/*
CREATE DATABASE bookstore
go
use bookstore
*/

CREATE TABLE Book (
    id INT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    image VARCHAR(255),
    price VARCHAR(50),
    quantity VARCHAR(50)
);

CREATE TABLE DetailBill (
    id INT PRIMARY KEY,
    book_id INT,
    quantity INT,
    FOREIGN KEY (book_id) REFERENCES Book(id)
);

INSERT INTO Book (id, title, image, price, quantity) VALUES
(1, 'Book Title 1', 'image1.jpg', '10.00', '100'),
(2, 'Book Title 2', 'image2.jpg', '15.00', '200'),
(3, 'Book Title 3', 'image3.jpg', '20.00', '150');

INSERT INTO DetailBill (id, book_id, quantity) VALUES
(1, 1, 2),
(2, 2, 3),
(3, 3, 1);