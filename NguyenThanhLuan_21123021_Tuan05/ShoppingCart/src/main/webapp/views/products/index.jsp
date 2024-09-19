<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <!-- View product -->
    <div id="main">
        <!-- title -->
        <div id="title">
            <h1>Product List</h1>
            <button>
                <a href="CartController">Add Product</a>
            </button>
        </div>
        <!-- product list -->
         <table>
            <thead>
                <th>
                    Name Product
                </th>
                <th>
                    Image
                </th>
                <th>
                    Price
                </th>
                <th>
                    Quantity
                </th>
                <th>
                    Action
                </th>
            </thead>
            <tbody>
                <c:forEach var="product" items="${products}" >
                    <tr>
                        <td>${product.name}</td>
                        <td>
                        	<img src="${product.image}" width="100px" height="100px">
                        </td>
                        <td>${product.price}</td>
                        <td>
                            <input type="number" value="1" min="1" max="100">
                        </td>
                        <td>
                            <button>
                                <a href="CartController">Add to Cart</a>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
         </table>
    </div>
</body>
<style>
    #main {
        margin: 0 auto;
        width: 80%;
    }

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
</html>