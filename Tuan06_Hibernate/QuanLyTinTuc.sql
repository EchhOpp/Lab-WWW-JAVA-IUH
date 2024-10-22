USE master

CREATE DATABASE QuanLyTinTuc;
GO

USE QuanLyTinTuc;
GO

CREATE TABLE DanhMuc (
    maDM NVARCHAR(50) PRIMARY KEY,
    tenDM NVARCHAR(255),
    moTa NVARCHAR(MAX),
    nguoiQL NVARCHAR(255),
    ghiChu NVARCHAR(255)
);
GO

CREATE TABLE TinTuc (
    maTT NVARCHAR(50) PRIMARY KEY,
    tieuDe NVARCHAR(255),
    noiDungTT NVARCHAR(MAX),
    lienKet NVARCHAR(255),
    maDM NVARCHAR(50),
    FOREIGN KEY (maDM) REFERENCES DanhMuc(maDM)
);
GO

INSERT INTO DanhMuc (maDM, tenDM, moTa, nguoiQL, ghiChu) VALUES
('DM001', N'Danh mục 1', N'Mô tả danh mục 1', N'Người quản lý 1', N'Ghi chú 1'),
('DM002', N'Danh mục 2', N'Mô tả danh mục 2', N'Người quản lý 2', N'Ghi chú 2'),
('DM003', N'Danh mục 3', N'Mô tả danh mục 3', N'Người quản lý 3', N'Ghi chú 3'),
('DM004', N'Danh mục 4', N'Mô tả danh mục 4', N'Người quản lý 4', N'Ghi chú 4'),
('DM005', N'Danh mục 5', N'Mô tả danh mục 5', N'Người quản lý 5', N'Ghi chú 5'),
('DM006', N'Danh mục 6', N'Mô tả danh mục 6', N'Người quản lý 6', N'Ghi chú 6'),
('DM007', N'Danh mục 7', N'Mô tả danh mục 7', N'Người quản lý 7', N'Ghi chú 7'),
('DM008', N'Danh mục 8', N'Mô tả danh mục 8', N'Người quản lý 8', N'Ghi chú 8'),
('DM009', N'Danh mục 9', N'Mô tả danh mục 9', N'Người quản lý 9', N'Ghi chú 9'),
('DM010', N'Danh mục 10', N'Mô tả danh mục 10', N'Người quản lý 10', N'Ghi chú 10');
GO

INSERT INTO TinTuc (maTT, tieuDe, noiDungTT, lienKet, maDM) VALUES
('TT001', N'Tiêu đề 1', N'Nội dung tin tức 1', 'http://example.com/1', 'DM001'),
('TT002', N'Tiêu đề 2', N'Nội dung tin tức 2', 'http://example.com/2', 'DM002'),
('TT003', N'Tiêu đề 3', N'Nội dung tin tức 3', 'http://example.com/3', 'DM003'),
('TT004', N'Tiêu đề 4', N'Nội dung tin tức 4', 'http://example.com/4', 'DM004'),
('TT005', N'Tiêu đề 5', N'Nội dung tin tức 5', 'http://example.com/5', 'DM005'),
('TT006', N'Tiêu đề 6', N'Nội dung tin tức 6', 'http://example.com/6', 'DM006'),
('TT007', N'Tiêu đề 7', N'Nội dung tin tức 7', 'http://example.com/7', 'DM007'),
('TT008', N'Tiêu đề 8', N'Nội dung tin tức 8', 'http://example.com/8', 'DM008'),
('TT009', N'Tiêu đề 9', N'Nội dung tin tức 9', 'http://example.com/9', 'DM009'),
('TT010', N'Tiêu đề 10', N'Nội dung tin tức 10', 'http://example.com/10', 'DM010');
GO