<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
</head>
<style>
    #top {
        display: flex;
        justify-content: space-between;
        align-items: center;
        background-color: #a09380;
        padding: 10px 20px;
    }
    
    h1 {
        color: white;
        background-color: #75736b;
        width: 300px;
        padding: 4px;
        border-radius: 5px;
        text-align: center;
    }

    #topleft {
        flex: 2;
    }

    #topright {
        flex: 1;
        display: flex;
        justify-content: space-around;
    }
    a {
        text-decoration: none;
        color: black;
        padding: 4px 10px;
        background-color: yellowgreen;
        border-radius: 5px;
        margin: 0 5px;
    }
    .btn {
        color: white;
        background-color: #75736b;
    }
    #body {
        display: flex;
        justify-content: space-between;
        padding: 8px 0;
    }
    #bodyleft {
        flex: 1;
        margin: 0 20px 0 0;
    }
    #bodyleft-aboutus {
        background-color: rgb(184, 184, 184);
        padding: 8px 20px;

    }
    #bodyright {
        flex: 2;
    }
    #bodyright-newbooks-list {
        display: flex;
        justify-content: space-around;
        flex-wrap: wrap;
        width: 100%;
    }
    .book {
        width: 28%;
        margin: 10px;
        padding: 10px;
        border: 1px solid black;
        border-radius: 5px;
        text-align: center;
    }
</style>
<body>
    <div id="top">
        <div id="topleft">
            <h1>
                IUH BOOKSTORE
            </h1>
        </div>
        <div id="topright">
            <!-- btn home -->
            <a href="home" class="btn btn-primary">Home</a>
            <!-- examples -->
            <a href="examples" class="btn btn-primary">Examples</a>
            <!-- services -->
            <a href="services" class="btn btn-primary">Services</a>
            <!-- product -->
            <a href="product" class="btn btn-primary">Product</a>
            <!-- contact -->
            <a href="contact" class="btn btn-primary">Contact</a>
        </div>
    </div>
    <div id="body">
        <div id="bodyleft">
            <div id="bodyleft-aboutus">
                <h2>About us</h2>
                <p style="text-align: justify;">
                    IUH Bookstore is a website that.... <b>Read More >></b>
                </p>
            </div>
            <div id="bodyleft-searchSite">
                <h2>Search site</h2>
                <form action="search" method="get">
                    <input type="text" name="search" placeholder="Search...">
                </form>
            </div>
            <div id="bodyleft-shoppingcart" >
                <a href="">
                    Shopping cart
                </a>
            </div>
        </div>
        <div id="bodyright">
            <div id="bodyright-newbooks">
                <div id="bodyright-newbooks-list">
					<c:forEach var="book" items="${books}">
						<div class="book">
							<p id="title">${book.title}</p>
							<img src="${pageContext.request.contextPath}/resource/images/${book.image}" alt="${book.title}" width="100px"
								height="150px">
							<p id="price">Price: ${book.price}</p>
							<p id="quanlity">Quantity: ${book.quantity}</p>
							<a href="${pageContext.request.contextPath}/bookdetail?id=${book.id}">Product detail</a> 
							<a href="${pageContext.request.contextPath}/bill?action=add&id=${book.id}">Add to cart</a>
						</div>
					</c:forEach>
				</div>
            </div>
    </div>
</body>
</html>