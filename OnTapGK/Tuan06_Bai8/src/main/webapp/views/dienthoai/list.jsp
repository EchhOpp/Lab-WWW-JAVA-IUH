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


	<div class="content">

		<h2>Danh sách điện thoại</h2>
		<table class="tableSP">
			<tr>
				<th>Mã điện thoại</th>
				<th>Tên điện thoại</th>
				<th>Năm sản xuất</th>
				<th>Cấu hình</th>
				<th>Nhà cung cấp</th>
			
			</tr>
			<c:forEach items="${listDT}" var="dt">
				<tr>
					<td>${dt.maDT}</td>
					<td>${dt.tenDT}</td>
						<td>${dt.namSX}</td>
					<td>${dt.cauHinh}</td>
					<td>${dt.nhaCC.tenNCC}</td>
					<td><a
						href="${pageContext.request.contextPath}/DienThoai?action=update&txtmaDT=${dt.maDT}">Sửa</a>
						| <a
						href="${pageContext.request.contextPath}/DienThoai?action=delete&txtmaDT=${dt.maDT}">Xóa</a></td>
				</tr>
			</c:forEach>
		</table>

	</div>

	<jsp:include page="../footer/footer.jsp"></jsp:include>

</body>

<style>
body {
	
}

.content {
	background-color: #f1f1f1;
}

.tableSP {
	margin: auto;
}

.tableSP th {
	background-color: #f1f1f1;
}

.tableSP td {
	border: 1px solid #ccc;
	padding: 10px;
}

.tableSP tr:nth-child(even) {
	background-color: #f2f2f2;
}
</style>
</html>