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
		<h2>Chỉnh sửa sản phẩm</h2>
		<form action="DienThoai?action=updateDT"
			method="post" class="forma">
			<table>
				
				<tr>
					<td>Tên sản phẩm <input type="hidden" name="txtmaDT" value="${dt.maDT}"></td>
					<td><input type="text" name="txttenDT" value="${dt.tenDT}"></td>
				</tr>
				<tr>
					<td>nam sản xuất</td>
					<td><input type="text" name="txtnamSX" value="${dt.namSX}"></td>
				</tr>
				<tr>
					<td>Cấu hình</td>
					<td><input type="text" name="txtcauHinh" value="${dt.cauHinh}"></td>
				</tr>
				<tr>
					<td colspan="2">Nhà Cung cấp</td>
				</tr>
				<tr>
					<td>Mã nhà cung cấp</td>
					<td><input type="text" name="txtmaNCC" value="${dt.nhaCC.maNCC }"></td>
				</tr>
				
				<tr>
					<td colspan="2"><input type="submit" value="Lưu" class="btn"></td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../footer/footer.jsp"></jsp:include>
</body>
</html>