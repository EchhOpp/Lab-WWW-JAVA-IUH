<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="header">
		<img src="../resources/img/iuh.png" alt="logo" class="imglogo" /> <a
			href="${pageContext.request.contextPath}/home/danhSach">Danh Sách</a>
		<a href="${pageContext.request.contextPath}/home/showFormAddDeTai">Thêm
			đề tài</a> <a
			href="${pageContext.request.contextPath}/home/showFormAddGiangVien">Thêm
			Giảng viên</a> <a href="${pageContext.request.contextPath}/home/danhSach">Chức
			năng quản lí</a>
	</div>
	<div class="container">
		<form:form action="${pageContext.request.contextPath}/home/addDetai"
			method="post" modelAttribute="deTai">
			<table>
				<tr>
					<td>Mã Đề Tài</td>
					<td><form:input path="maDeTai" /></td>
					<td><form:errors path="maDeTai" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Tên Đề Tài</td>
					<td><form:input path="tenDeTai" /></td>
					<td><form:errors path="tenDeTai" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Mô Tả</td>
					<td><form:input path="moTaDeTai" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Năm Thực Hiện</td>
					<td><form:input path="nam" /></td>
					<td><form:errors path="nam" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Hình ảnh</td>
					<td><form:input path="urlHinh" /></td>
					<td></td>
				</tr>
				<tr>
					<td>Giảng Viên</td>
					<td><form:select path="giangVien.maGV">
							<form:options items="${list}" itemValue="maGV" itemLabel="tenGV" />
						</form:select></td>
					<td></td>
				<tr>
					<td></td>
					<td></td>
					<td><input type="submit" value="Thêm"></td>
				</tr>
			</table>
		</form:form>
		<a href="${pageContext.request.contextPath}/home/danhSach">Quay
			lại</a>
	</div>
</body>
<style>
.error {
	color: red;
}

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

.container {
	margin: 20px;
	width: 100%;
}

table {
	border-collapse: collapse;
	width: 80%;
}

td {
	width: 350px;
	padding: 10px;
}

input[type="text"], select {
	width: 100%;
	padding: 5px;
}

input[type="submit"] {
	padding: 5px 10px;
	background-color: #4CAF50;
	color: white;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}
</style>
</html>