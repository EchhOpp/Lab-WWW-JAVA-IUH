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
<jsp:include page="../header/header.jsp"></jsp:include>
	<div>
		<h2>Danh sách xe</h2>
		<table border="1" style="width: 100%">
			<tr>
				<th>Mã xe</th>
				<th>Tên xe</th>
				<th>Giá xe</th>
				<th>Năm sản xuất</th>
				<th>Mã hãng xe</th>
			</tr>
			<c:forEach items="${list}" var="items">
				<tr>
					<td>${items.maXe}</td>
					<td>${items.tenXe}</td>
					<td>${items.giaXe}</td>
					<td>${items.namSanXuat}</td>
					<td>${items.maHangXe}</td>
				</tr>
			</c:forEach>
		</table>
		<jsp:include page="../footer/footer.jsp"></jsp:include>
</body>
</html>