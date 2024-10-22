CREATE DATABASE QuanLyDeTai
GO

use QuanLyDeTai
go

CREATE TABLE GiangVien (
	MaGV Nvarchar(255) primary key,
	TenGV NVARCHAR(255),
	LinhVucNghienCuu NVARCHAR(255),	
	SoDienThoai NVARCHAR(255),
)

CREATE TABLE DeTai (
	MaDeTai NVARCHAR(255) PRIMARY KEY,
	TenDeTai NVARCHAR(255),
	NamDangKy NVARCHAR(255),
	MoTaDeTai NVARCHAR(255),
	MaGV NVARCHAR(255) FOREIGN KEY REFERENCES GiangVien(MaGV)
)

go

INSERT INTO GiangVien (MaGV, TenGV, LinhVucNghienCuu, SoDienThoai)
VALUES 
('GV01', 'Professor A', 'Computer Science', '1234567890'),
('GV02', 'Professor B', 'Mathematics', '2345678901'),
('GV03', 'Professor C', 'Physics', '3456789012'),
('GV04', 'Professor D', 'Chemistry', '4567890123'),
('GV05', 'Professor E', 'Biology', '5678901234');

INSERT INTO DeTai (MaDeTai, TenDeTai, NamDangKy, MoTaDeTai, MaGV)
VALUES 
('DT01', 'Project A', '2022', 'Description of Project A', 'GV01'),
('DT02', 'Project B', '2022', 'Description of Project B', 'GV02'),
('DT03', 'Project C', '2022', 'Description of Project C', 'GV03'),
('DT04', 'Project D', '2022', 'Description of Project D', 'GV04'),
('DT05', 'Project E', '2022', 'Description of Project E', 'GV05');
('DT011', 'Project AA', '2022', 'Description of Project A', 'GV01'),
('DT022', 'Project BB', '2022', 'Description of Project B', 'GV02'),
('DT033', 'Project CC', '2022', 'Description of Project C', 'GV03'),
('DT044', 'Project DD', '2022', 'Description of Project D', 'GV04'),
('DT055', 'Project EE', '2022', 'Description of Project E', 'GV05');