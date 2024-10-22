<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    #header {
        background-image: url("${pageContext.request.contextPath}/resource/image/bg.jpg");
        background-size: contain;
        background-position: center;
        height: 50px;
        padding: 20px;
    }
    #main {
        width: 80%;
        margin: 0 auto;
        border: 1px solid #ccc;
    }
    #content {
    }
    #nav {
        margin: 0;
        padding: 8px 0;
        border-bottom: 1px solid #ccc;
        text-align: center;
    }
    #footer {
        margin: 0;
        padding: 8px 0;
        border-top: 1px solid #ccc;
        text-align: center;
    }

    #news {
        padding: 10px;
    }
    #tablenew {
        width: 100%;
        border-collapse: collapse;
    }
    #tablenew th {
        border: 1px solid #ccc;
        padding: 10px;
        text-align: center;
    }
    #tablenew td {
        border: 1px solid #ccc;
        padding: 10px;
    }
    #tablenew tr:nth-child(odd) {
        background-color: #f2f2f2;
    }
    #tablenew tr:nth-child(even) {
        background-color: #fff;
    }
    
    #tablenew tr:hover {
        background-color: #ccc;
    }

    a {
        text-decoration: none;
        color: white;
        background-color: #007e22;
        padding: 5px;
        text-align: center;
        border-radius: 6px;
    }
    a:hover {
        color: red;
    }
</style>
</head>
<body>
    <div id="main">
        <div id="header">
            <!-- Content of the header -->
        </div>