<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="jakarta.tags.core"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Danh Sách Đề Tài Theo Giảng Viên</h1>
<h2>Giảng Viên: ${gv.tenGV}</h2>
<a href="${pageContext.request.contextPath}/home/showFormAddDeTai">Thêm đề tài</a>
	<table>
		<tr>
			<th>Mã Đề Tài</th>
			<th>Tên Đề Tài</th>
			<th>Mô Tả</th>
			<th>Năm Thực Hiện</th>
		</tr>
		<c:forEach var="deTai" items="${list}">
			<tr>
				<td>${deTai.maDeTai}</td>
				<td>${deTai.tenDeTai}</td>
				<td>${deTai.moTaDeTai}</td>
				<td>${deTai.nam}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/home/danhSach">Quay lại</a>
</body>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

table, th, td {
	border: 1px solid black;
	padding: 10px;
}

a {
	text-decoration: none;
	margin: 10px;
	padding: 10px;
}
</style>
</html>