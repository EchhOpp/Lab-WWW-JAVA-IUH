<%@page import="student.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ServletStudent" method="post">
		<table>
			<tr>
				<td>First name:</td>
				<td><input type="text" name="studentFName"></td>
			</tr>
			<tr>
				<td>Last name:</td>
				<td><input type="text" name="studentLName"></td>
			</tr>
			<tr>
				<td>Date of birth:</td>
				<td><input type="date" name="studentDOB"></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="studentEmail"></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><input type="text" name="studentPhone"></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td>
					<input type="radio" name="gender" id="male" value="Male">Male
					<input type="radio" name="gender" id="female" value="Female">Female
				</td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><textarea name="studentAddress" rows="4" cols="50"></textarea></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><input type="text" name="studentCity"></td>
			</tr>
			<tr>
				<td>Pin code:</td>
				<td><input type="text" name="studentPin"></td>
			</tr>
			<tr>
				<td>State:</td>
				<td><input type="text" name="studentState"></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><input type="text" name="studentCountry" value="India"></td>
			</tr>
			<tr>
				<td>Hobbies:</td>
				<td>
					Drawing
					<input type="checkbox" name="studentHobbies" value="Reading">
					Singing
					<input type="checkbox" name="studentHobbies" value="Writing">
					Dancing
					<input type="checkbox" name="studentHobbies" value="Playing">
					Sketching
					<input type="checkbox" name="studentHobbies" value="Playing">
					Others
					<input type="checkbox" name="studentHobbies" value="Playing">
					<input type="text" name="studentHobbies">
				</td>
			</tr>
			<tr>
				<td>Qualification:</td>
				<td>
					<table>
						<tr>
							<td>SL.No.Examination</td>
							<td>Board</td>
							<td>Percentage</td>
							<td>Year of Passing</td>
						</tr>
						<tr>
							<td>1.  Class X</td>
							<td><input type="text" name="studentBoard1"></td>
							<td><input type="text" name="studentPercentage1"></td>
							<td><input type="text" name="studentYear1"></td>
						</tr>
						<tr>
							<td>2.  Class XII</td>
							<td><input type="text" name="studentBoard2"></td>
							<td><input type="text" name="studentPercentage2"></td>
							<td><input type="text" name="studentYear2"></td>
						</tr>
						<tr>
							<td>3.  Graduation</td>
							<td><input type="text" name="studentBoard3"></td>
							<td><input type="text" name="studentPercentage3"></td>
							<td><input type="text" name="studentYear3"></td>
						</tr>
						<tr>
							<td>4.  Post Graduation</td>
							<td><input type="text" name="studentBoard4"></td>
							<td><input type="text" name="studentPercentage4"></td>
							<td><input type="text" name="studentYear4"></td>
						</tr>
						<tr>
							<td></td>
							<td>(10 char max)</td>
							<td>(upto 2 decimal)</td>
							<td></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>Course Applied for</td>
				<td>
					BCA
					<input type="radio" name="studentCourse" value="BCA">
					B.Com
					<input type="radio" name="studentCourse" value="B.Com">
					B.Sc
					<input type="radio" name="studentCourse" value="B.Sc">
					A
					<input type="radio" name="studentCourse" value="A">
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
				<td><input type="reset" value="Reset"></td>
			</tr>
		</table>
	</form>
</body>
</html>