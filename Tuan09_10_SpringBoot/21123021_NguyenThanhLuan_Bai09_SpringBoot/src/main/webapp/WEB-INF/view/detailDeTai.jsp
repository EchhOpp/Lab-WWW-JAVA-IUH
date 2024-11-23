<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>Mã Đề Tài</th>
			<th>Tên Đề Tài</th>
			<th>Mô Tả</th>
			<th>Năm Thực Hiện</th>
		</tr>

		<tr>
			<td>${dt.maDeTai}</td>
			<td>${dt.tenDeTai}</td>
			<td>${dt.moTaDeTai}</td>
			<td>${dt.nam}</td>
		</tr>
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