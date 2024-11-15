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
<h2 style="text-align: center">Danh sách lớp hoc</h2>
	<table border="1" style="width: 100%">
		<tr>S
			<th>Mã lớp học</th>
			<th>Tên lớp học</th>
			<th></th>
		</tr>
		<c:forEach items="${list}" var="items">
			<tr>
				<td>${items.maLop}</td>
				<td>${items.tenLop}</td>
				<td><a href="${pageContext.request.contextPath}/TTController?action=showChiTiet&maLop=${items.maLop}">Xem danh sach</a></td>
			</tr>
		</c:forEach>
<jsp:include page="../footer/footer.jsp"></jsp:include>
</body>
</html>