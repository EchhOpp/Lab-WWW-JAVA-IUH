<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
#title {
	display: flex;
	justify-content: space-between;
	align-items: center;
	background-color: green;
	margin-bottom: 30px;
	padding: 10px;
}

table {
	width: 100%;
	border-collapse: collapse;
}

th, td {
	border: 1px solid black;
	text-align: center;
}

th {
	background-color: #f2f2f2;
}

img {
	display: block;
	margin: 0 auto;
}

button {
	background-color: blue;
	border: none;
	border-radius: 5px;
	color: white;
	padding: 4px 12px;
	text-align: center;
	display: inline-block;
	font-size: 12px;
	margin: 4px 2px;
	cursor: pointer;
}

a {
	text-decoration: none;
	color: white;
}
</style>
<body>
    <div id="title">
            <h1>Cart</h1>
            <button>
                <a href="${pageContext.request.contextPath}/product" >Add Product</a>
            </button>
    </div>
    <table>
        <thead>
            <tr>
                <th>Option</th>
                <th>Id</th>
                <th>Name</th>
                <th>Image</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Sub Total</th>
            </tr>
        </thead>
        <tbody>
        	<c:set var="total" value="0"></c:set>
			<c:forEach var="item" items="${sessionScope.cart}">
				<c:set var="total"
					value="${total + item.product.price * item.quantity}"></c:set>
				<tr>
					<td>
						<button>
						<a href="${pageContext.request.contextPath}/cart?action=remove&id=${item.product.id}">Remove</a>
						</button>
					</td>
					<td>${item.product.id}</td>
					<td>${item.product.name}</td>
					<td>
						<p>${item.product.image}</p>
						<img src="${pageContext.request.contextPath}/resources/images/${item.product.image}" width="100px" height="100px">
					</td>
					<td>${item.product.price}</td>
					<td>${item.quantity}</td>
					<td>${item.product.price * item.quantity}</td>
				</tr>
			</c:forEach>
		</tbody>
    </table>
</body>
</html>