<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh Sách</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap"
	rel="stylesheet">
</head>
<body>
	<div class="header">
		<img src="../resources/img/iuh.png" alt="logo" class="imglogo" /> 
		<a href="${pageContext.request.contextPath}/home/danhSach">Danh Sách</a> 
		<a href="${pageContext.request.contextPath}/home/showFormAddDeTai">Thêm đề tài</a> 
		<a href="${pageContext.request.contextPath}/home/showFormAddGiangVien">Thêm Giảng viên</a>
		<a href="${pageContext.request.contextPath}/home/danhSach">Chức năng quản lí</a>
	</div>


	<h1>Danh Sách</h1>
	<table border="1">
		<tr>
			<th>Mã GV</th>
			<th>Tên GV</th>
			<th>Lĩnh Vực Nghiên Cứu</th>
			<th>Điện Thoại</th>
			<th>Email</th>
			<th>Danh Sách Đề tài</th>
		</tr>
		<c:forEach var="giangVien" items="${list}">
			<tr>

				<td><a
					href="${pageContext.request.contextPath}/home/detail?maGV=${giangVien.maGV}">${giangVien.maGV}</a></td>
				<td>${giangVien.tenGV}</td>
				<td>${giangVien.linhVucNghienCuu}</td>
				<td>${giangVien.dienThoai}</td>
				<td>${giangVien.email}</td>
				<td><c:forEach var="deTai" items="${giangVien.dsDeTai}">
						<ul>
							<li><a
								href="${pageContext.request.contextPath}/home/detailDeTai?maDeTai=${deTai.maDeTai}">${deTai.tenDeTai}</a>
							</li>
						</ul>
					</c:forEach></td>
			</tr>
		</c:forEach>
	</table>
</body>

<style>
body {
	font-family: 'Roboto', sans-serif;
}

.header {
	background-color: #f1f1f1;
	padding: 20px;
	text-align: center;
	font-size: 20px;
	display: flex;
	justify-content: flex-start;
	align-items: center;
}

.imglogo {
	width: 50px;
	height: 50px;
	margin-right: 10px;
}

.header a {
	margin: 0 10px;
	vertical-align: middle;
}

table {
	width: 100%;
	border-collapse: collapse;
}

table, th, td {
	border: 1px solid black;
	text-align: center;
}
</style>
</html>