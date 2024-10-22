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
	<h2>Thêm tin tức</h2>
		<form action="TTController?action=addTT" method="post">
			<table>
				<tr>
					<td>Mã tin tức</td>
					<td><input type="text" name="txtmaTT"></td>
				</tr>
				<tr>
					<td>Tiêu đề</td>
					<td><input type="text" name="txttieuDe"></td>
				</tr>
				<tr>
					<td>Nội dung</td>
					<td><input type="text" name="txtnoiDungTT"></td>
				</tr>
				<tr>
					<td>Liên kết</td>
					<td><input type="text" name="txtlienKet"></td>
				</tr>
				<tr>
					<td>Mã danh mục</td>
					<td><input type="text" name="txtmaDM"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Thêm mới"></td>
				</tr>
			</table>
		</form>
	</div>
<jsp:include page="../footer/footer.jsp"></jsp:include>
</div>
</body>
</html>