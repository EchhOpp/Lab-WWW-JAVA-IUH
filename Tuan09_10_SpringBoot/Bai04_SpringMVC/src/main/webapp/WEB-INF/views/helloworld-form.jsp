<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World - Input Form</h1>
	<form action="processForm" method="post">
		Enter your name: 
		<input type="text" name="studentName" 
			placeholder="What's your name?"
		/> 
		<input type="submit" />
	</form>
</body>
</html>