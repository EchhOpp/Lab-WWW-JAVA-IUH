-- Bật IDENTITY_INSERT cho bảng category
SET IDENTITY_INSERT dbo.category ON;

-- Thêm dữ liệu cho bảng category
INSERT INTO dbo.category (category_id, name) VALUES
(1, N'Điện thoại'),
(2, N'Laptop'),
(3, N'Máy tính bảng'),
(4, N'Phụ kiện'),
(5, N'Đồng hồ thông minh');

-- Tắt IDENTITY_INSERT cho bảng category
SET IDENTITY_INSERT dbo.category OFF;

-- Bật IDENTITY_INSERT cho bảng product
SET IDENTITY_INSERT dbo.product ON;

-- Thêm dữ liệu cho bảng product
INSERT INTO dbo.product (cart_id, code, description, name, price, register_date, category_id) VALUES
(1, 'IP14', N'iPhone 14 Pro Max 256GB', N'iPhone 14', 27990000, '2023-09-15', 1),
(2, 'SS23', N'Samsung Galaxy S23 Ultra', N'Galaxy S23', 23990000, '2023-08-20', 1),
(3, 'MB14', N'Macbook Pro M2 14 inch', N'Macbook Pro', 45990000, '2023-10-01', 2),
(4, 'DL15', N'Dell XPS 15 9520', N'Dell XPS', 35990000, '2023-09-25', 2),
(5, 'IP13', N'iPad Pro M2 11 inch', N'iPad Pro', 19990000, '2023-07-30', 3),
(6, 'APW8', N'Apple Watch Series 8', N'Apple Watch', 9990000, '2023-08-15', 5),
(7, 'APD2', N'AirPods Pro 2', N'AirPods Pro', 4990000, '2023-09-10', 4),
(8, 'OP11', N'OPPO Reno 11', N'OPPO Reno', 12990000, '2023-11-20', 1),
(9, 'HP15', N'HP Pavilion 15', N'HP Pavilion', 15990000, '2023-10-15', 2),
(10, 'SSTP', N'Samsung Tab S9', N'Galaxy Tab', 18990000, '2023-09-05', 3);

-- Tắt IDENTITY_INSERT cho bảng product
SET IDENTITY_INSERT dbo.product OFF;