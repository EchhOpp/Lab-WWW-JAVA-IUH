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
<div>
		<form action="CHXMController?action=add" method="post">
			<table>
				<tr>
					<td>Mã xe</td>
					<td><input type="text" name="txtmaXe"></td>
				</tr>
				<tr>
					<td>Tên xe</td>
					<td><input type="text" name="txttenXe"></td>
				</tr>
				<tr>
					<td>Giá xe</td>
					<td><input type="text" name="txtgiaXe"></td>
				</tr>
				<tr>
					<td>Năm sản xuất</td>
					<td><input type="text" name="txtnamSanXuat"></td>
				</tr>
				<tr>
					<td>Mã hãng xe</td>
					<td><input type="text" name="txtmaHangXe"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Thêm mới"></td>
				</tr>
			</table>
	</div>
<jsp:include page="../footer/footer.jsp"></jsp:include>
</body>
</html>