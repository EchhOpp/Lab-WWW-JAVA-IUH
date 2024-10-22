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
(3, 'Book Title 3', 'image3.jpg', '20.00', '150'),
(4, 'Book Title 4', 'image1.jpg', '25.00', '120'),
(5, 'Book Title 5', 'image2.jpg', '30.00', '130'),
(6, 'Book Title 6', 'image3.jpg', '35.00', '140'),
(7, 'Book Title 7', 'image1.jpg', '40.00', '110'),
(8, 'Book Title 8', 'image2.jpg', '45.00', '160'),
(9, 'Book Title 9', 'image3.jpg', '50.00', '170'),
(10, 'Book Title 10', 'image1.jpg', '55.00', '180');

INSERT INTO DetailBill (id, book_id, quantity) VALUES
(1, 1, 2),
(2, 2, 3),
(3, 3, 1),
(4, 4, 2),
(5, 5, 3),
(6, 6, 1),
(7, 7, 2),
(8, 8, 3),
(9, 9, 1),
(10, 10, 2);