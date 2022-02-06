<%@page import="groceryExampleWeb.Grocery"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="showDetails" method = "post">

Enter ID <input type="number" name="id"/>
<br><br>

<input type="submit" value="Show Details"/>

</form>

<%
	Grocery gr = (Grocery)session.getAttribute("grocery");

	request.setAttribute("gr", gr);
%>
<h3><b>${gr }</b></h3>




</body>
</html>