<%@page import="study.RandomNumber"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>ex2.jsp</h1>

page level =<%= pageContext.getAttribute("greeting") %>
<br>
application level =<%=application.getAttribute("proverb") %>
<br>
request level =<%=request.getAttribute("wrycry") %>
<br>
session level =<%=session.getAttribute("country") %>
<br>
application = <%= ((RandomNumber)application.getAttribute("random")).getRandomNumber() %>
</body>
</html>