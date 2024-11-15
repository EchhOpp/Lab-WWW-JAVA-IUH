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
	<div class="content">
		<h2>Thêm mới sản phẩm</h2>
		<form action="DienThoai?action=addDT"
			method="post" class="forma">
			<table>
				<tr>
					<td>Tên sản phẩm</td>
					<td><input type="text" name="txttenDT"></td>
				</tr>
				<tr>
					<td>Năm sản xuất</td>
					<td><input type="text" name="txtnamSX"></td>
				</tr>
				<tr>
					<td>Cấu hình</td>
					<td><input type="text" name="txtcauHinh"></td>
				</tr>
				<tr>
					<td colspan="2">Nhà Cung cấp</td>
				</tr>
				<tr>
					<td>Mã nhà cung cấp</td>
					<td><input type="text" name="txtmancc"></td>
				</tr>
				<tr>
					<td>Tên nhà cung cấp</td>
					<td><input type="text" name="txttenNCC"></td>
				</tr>
				<tr>
					<td>Địa chỉ</td>
					<td><input type="text" name="txtdiaChi"></td>
				</tr>
				<tr>
					<td>Số điện thoại</td>
					<td><input type="text" name="txtsdt"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Thêm mới" class="btn"></td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../footer/footer.jsp"></jsp:include>
</body>
<style>
body {
	
}

table {
	margin: auto;
}

table tr td {
	padding: 10px;
}

.forma {
	margin-top: 50px;
}

.btn {
	background-color: #4CAF50;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}
</style>
</html>