<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="text-align, center; border: 1px solid black; padding: 10px;">
		<h1>CỬA HÀNG BÁN XE GẮN MÁY ABC</h1>
		<ul>
			<li><a href="${pageContext.request.contextPath}/CHXMController?action=ShowList">Danh sách xe</a></li>
			<li><a href="${pageContext.request.contextPath}/CHXMController?action=ShowAdd">Thêm xe</a></li>
		</ul>
		<form action="CHXMController?action=search" method="post">
			<input type="text" name="txtSearch" /> 
			<input type="submit" value="Tìm kiếm" />
		</form>
	</div>
</body>
</html>