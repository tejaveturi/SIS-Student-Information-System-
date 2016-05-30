<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="skyblue">
<h1>DAILINFO</h1>
<%String admin=(String)request.getAttribute("name"); %>
WELCOME <%=admin %> 
<form action="AdminLogin.html">
<table>
<tr>
<td><a href="StudentReg.html">Register Student</a></td>
</tr>
<tr><td><a href="FacultyReg.html">Register Faculty</a></td></tr>
<tr><td><input type="submit" value="logout"></input></td></tr>
</table>
</form>
</body>
</html>  