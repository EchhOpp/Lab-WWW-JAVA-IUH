/*
Create database ListProduct

use ListProduct
*/

CREATE TABLE products (
    product_id INT PRIMARY KEY,
    product_name NVARCHAR(255),
    product_model NVARCHAR(255),
    product_description NVARCHAR(255),
    product_quantity INT,
    product_price NVARCHAR(255),
    product_imgURL NVARCHAR(255)
);

CREATE TABLE carts (
	 cart_id int primary key,
	 user_id int, 
);

CREATE TABLE CART_ITEMS (
	cart_item_id INT PRIMARY KEY,
	cart_id int,
	product_id int,
	quantity int,
	FOREIGN KEY (cart_id) REFERENCES carts(cart_id) ON DELETE CASCADE,
	FOREIGN KEY (product_id) REFERENCES products(product_id) ON DELETE CASCADE
);



