<%@page import="com.java.miniproject.entity.User"%>

<%@page import="com.sun.corba.se.spi.ior.MakeImmutable"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
User nuser = (User)session.getAttribute("user");
String user_name = nuser.getFirstName()+ " "+ nuser.getLastName();

%>


<h3>Welcome <%=user_name %>!!!</h3>
</body>
</html>