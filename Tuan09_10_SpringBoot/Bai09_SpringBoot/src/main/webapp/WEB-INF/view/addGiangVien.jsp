<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="header">
		<img src="../resources/img/iuh.png" alt="logo" class="imglogo" /> 
		<a href="${pageContext.request.contextPath}/home/danhSach">Danh Sách</a> 
		<a href="${pageContext.request.contextPath}/home/showFormAddDeTai">Thêm đề tài</a> 
		<a href="${pageContext.request.contextPath}/home/showFormAddGiangVien">Thêm Giảng viên</a>
		<a href="${pageContext.request.contextPath}/home/danhSach">Chức năng quản lí</a>
	</div>
	<div class="container">
		<form:form action="${pageContext.request.contextPath}/home/addGiangVien" method="post" modelAttribute="giangVien">
			<table>
				<tr>
					<td>Mã Giảng viên</td>
					<td>
						<form:input path="maGV" />
					</td>
					<td>
						<form:errors path="maGV" cssClass="error" />
					</td>
				</tr>
				<tr>
					<td>Tên Giảng viên</td>
					<td>
						<form:input path="tenGV"  />
					</td>
					<td>
						<form:errors path="tenGV" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td>Email</td>
					<td>
						<form:input path="email" />
					</td>
					<td>
						<form:errors path="email" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td>Lĩnh vực nghiên cứu</td>
					<td>
						<form:input path="linhVucNghienCuu" />
					</td>
					<td></td>
				</tr>
				<tr>
					<td>Điện thoại</td>
					<td>
						<form:input path="dienThoai" />
					</td>
					<td>
						<form:errors path="dienThoai" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Thêm"></td>
					<td></td>
				</tr>
			</table>
		
		</form:form>
		<a href="${pageContext.request.contextPath}/home/danhSach">Quay lại</a>
	</div>
</body>
<style>
body {
	font-family: 'Roboto', sans-serif;
}

.error {
	color: red;
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
	padding: 50px;
}

form {
	width: 100%;
}

table {
	border-collapse: collapse;
	width: 80%;
}

td {
	padding: 10px;
	width:280px;
}

input[type="text"] {
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