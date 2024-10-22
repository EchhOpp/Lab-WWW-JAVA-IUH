<%@page import="student.Student"%>
<%@page import="student.Qualification"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	Student svt= new Student();
	svt = (Student)request.getAttribute("student");
	String hobbyString = "";
	for(String hobby: svt.getHobbies()) {
		hobbyString += hobby + ", ";
    }
	out.println("First name:" + svt.getFirstName()
	+ "<br/> Last name: " + svt.getLastName()
	+ "<br/> Date of birth: " + svt.getDob()
	+ "<br/> Email : " + svt.getEmail()
	+ "<br/> Phone: " + svt.getPhone()
	+ "<br/> Gender: " +svt.getGender()
	+ "<br/> Address: " + svt.getAddress()
	+ "<br/> City: " + svt.getCity()
	+ "<br/> Pin code: " + svt.getPincode()
	+ "<br/> State: " + svt.getState()
	+ "<br/> Country: " + svt.getCountry()
	+ "<br/> Hobbies: " + hobbyString
	+ "<br/> Qualification: " + svt.getQualification1() + ", " + svt.getQualification2() + ", " + svt.getQualification3() + ", " + svt.getQualification4()
	+ "<br/> Course: " + svt.getCourse()
	);
	%>
</body>
</html>