/*
CREATE DATABASE shopping
go
use shopping
*/
-- Create Product table
CREATE TABLE Product (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price FLOAT NOT NULL,
    img VARCHAR(255)
);

-- Create CartItem table
CREATE TABLE CartItem (
    id INT PRIMARY KEY,
    product_id INT,
    quantity INT NOT NULL,
    cart_id INT,
    FOREIGN KEY (product_id) REFERENCES Product(id)
);

-- Insert sample data into Product table
INSERT INTO Product (id, name, price, img) VALUES
(1, 'Product A', 10.99, 'img_a.jpg'),
(2, 'Product B', 20.99, 'img_b.jpg'),
(3, 'Product C', 30.99, 'img_c.jpg');

-- Insert sample data into CartItem table
INSERT INTO CartItem (id, product_id, quantity, cart_id) VALUES
(1, 1, 2, 101),
(2, 2, 1, 101),
(3, 3, 5, 102);