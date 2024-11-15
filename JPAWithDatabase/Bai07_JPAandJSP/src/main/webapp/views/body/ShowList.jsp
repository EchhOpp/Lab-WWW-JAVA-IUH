<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../header/header.jsp"></jsp:include>
<div>
	<h2>Danh sách tin tức</h2>
		<table border="1" style="width: 100%">
			<tr>
				<th>Mã tin tức</th>
				<th>Tiêu đề</th>
				<th>Nội dung</th>
				<th>Liên kết</th>
				<th>Mã danh mục</th>
			</tr>
			<c:forEach items="${list}" var="items">
				<tr>
					<td>${items.maTT}</td>
					<td>${items.tieuDe}</td>
					<td>${items.noiDungTT}</td>
					<td>${items.lienKet}</td>
					<td>${items.danhMuc.maDM}</td>
				</tr>
			</c:forEach>
		</table>
</div>
<jsp:include page="../footer/footer.jsp"></jsp:include>
</div>
</body>
</html>