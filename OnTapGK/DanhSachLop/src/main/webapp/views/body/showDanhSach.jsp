<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../header/header.jsp"></jsp:include>
	<table border="1" style="width: 100%">
		<tr>
			<th>Mã sinh viên</th>
			<th>Tên sinh viên</th>
			<th>Email</th>
			<th>Địa chỉ</th>
			<th>Điện thoại</th>
			<th>Hình ảnh</th>
			<th>Lớp học</th>
			<th></th>
		</tr>
		<c:forEach items="${list}" var="items">
			<tr>
				<td>${items.id}</td>
				<td>${items.tenSV}</td>
				<td>${items.email}</td>
				<td>${items.diaChi}</td>
				<td>${items.dienThoai}</td>
				<td>${items.hinhAnh}</td>
				<td>${items.lopHoc.tenLop}</td>
			</tr>
		</c:forEach>
		<jsp:include page="../footer/footer.jsp"></jsp:include>
</body>
</html>