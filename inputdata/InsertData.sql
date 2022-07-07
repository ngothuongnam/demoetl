-- Create 2 databases
CREATE DATABASE bookstore
	CHARACTER SET "utf8mb4"
	COLLATE "utf8mb4_general_ci";
USE bookstore;
CREATE TABLE book(
	id VARCHAR(20) NOT NULL,
	tenSach VARCHAR(255),
	giaBan FLOAT(10,2),
	namXuatBan YEAR,
	ngayXuatBan DATE,
	CONSTRAINT PK_sach PRIMARY KEY (id)	
);
CREATE DATABASE nhasach
	CHARACTER SET "utf8mb4"
	COLLATE "utf8mb4_general_ci";
USE nhasach;
CREATE TABLE sach(
	id VARCHAR(20) NOT NULL,
	tenSach VARCHAR(255),
	giaBan FLOAT(10,2),
	namXuatBan YEAR,
	ngayXuatBan DATE,
	CONSTRAINT PK_sach PRIMARY KEY (id)	
);

-- Insert data to "Sach" table
INSERT INTO sach(id, tenSach, giaBan, namXuatBan, ngayXuatBan)
VALUES 
('KTMT', 'Kiến trúc máy tính', 35000, 2015, '2015-4-14'),
('NMCNTT', 'Nhập môn CNTT', 40000, 2015, '2015-4-21'),
('THUD', 'Tin học ứng dụng', 30000, 2016, '2016-7-20'),
('CSDL', 'Cơ sở dữ liệu', 50000, 2016, '2016-2-15'),
('MMT', 'Mạng máy tính', 55000, 2017, '2017-9-26'),
('KTLT', 'Kỹ thuật lập trình', 35000, 2017, '2017-1-11'),
('LTM', 'Lập trình mạng', 60000, 2017, '2017-2-28'),
('TRR', 'Toán rời rạc', 60000, 2015, '2015-4-1'),
('LTHDT', 'Lập trình hướng đối tượng', 70000, 2016, '2016-12-15'),
('CTDLGT', 'Cấu trúc dữ liệu và giải thuật', 75000, 2018, '2018-3-24'),
('CNPM', 'Công nghệ phần mềm', 50000, 2018, '2018-1-6'),
('LTJV', 'Lập trình Java', 40000, 2017, '2017-2-28'),
('LTPT', 'Lập trình Python', 40000, 2017, '2017-6-10'),
('HDH', 'Hệ điều hành', 55000, 2019, '2019-8-2'),
('DTDM', 'Điện toán đám mây', 55000, 2016, '2016-2-20'),
('HTBD', 'Hệ thống Big Data', 60000, 2020, '2020-9-13'),
('TTNT', 'Trí tuệ nhân tạo', 80000, 2020, '2020-3-2'),
('KTDL', 'Khai thác dữ liệu', 45000, 2021, '2021-11-1'),
('ATTT', 'An toàn thông tin', 75000, 2017, '2017-1-13');