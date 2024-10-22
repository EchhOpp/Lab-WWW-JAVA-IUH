<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="header">
		<div class="viewHeader">
			<img alt="" src="${pageContext.request.contextPath}/images/fongo.png" class="imgHeader">
		</div>
		<div class="navigation22">
			<nav class="navigation2">
				<ul>
					<li><a href="${pageContext.request.contextPath}/DienThoai" class="itemnav">Danh sách sản phẩm </a></li>
					<li><a href="${pageContext.request.contextPath}/DienThoai?action=add" class="itemnav">Thêm mới sản phẩm </a></li>
					<li><a href="${pageContext.request.contextPath}/DienThoai?" class="itemnav">Chức năng quản lý</a></li>
				</ul>
			</nav>
		</div>
	</div>
</body>
<style>
body {
	
}

.header {
	width: 100%;
	height: 212px;
	background-color: #ffffff;
	border: 1px solid #77abf6;
		
}

.viewHeader {
	display: flex;
	justify-content: center;
	align-items: center;
}

.imgHeader {
	width: 500px;
	height: 160px;
}

.navigation22 {
	display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
	 border: 1px solid #77abf6;
}
.navigation2 ul {
	display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
}

.navigation2 ul li {
	list-style-type: none;
	text-align: center;
}

.itemnav {
	color: #77abf6;
	font-size: 16px;
	font-weight: bold;
	margin-right: 20px;
	vertical-align: middle;
}
</style>
</html>