<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Student</title>
</head>
<body>
	<table>
		<tr><th>Student Name: </th> <td>Student Age:</td></tr>
		<c:forEach var="student" items="${students}"}
			<tr><td>${student.name})</td><td>${student.age}</td></tr>
		</c:forEach>
		
	</table>
</body>
</html>