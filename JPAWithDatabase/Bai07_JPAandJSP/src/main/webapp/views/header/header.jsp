<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="border: 1px solid black; background-color: #f0f0f0; padding: 10px; margin: 10px">
    <div id="header">
    	<h2 style="text-align: center">Quản lý tin tức</h2>
		<div style="text-align: center">
			<a href="${pageContext.request.contextPath}/TTController?action=showDanhSach">Danh sách tin tức |</a>
			<a href="${pageContext.request.contextPath}/TTController?action=showThemTT">Thêm mới tin tức |</a>
			<a href="${pageContext.request.contextPath}/TTController?action=showQL">Quản lý tin tức</a>
		</div>
    </div>
</body>
</html>