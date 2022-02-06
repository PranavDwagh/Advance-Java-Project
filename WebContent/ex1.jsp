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
<%

	application.setAttribute("random",new RandomNumber(50));

	pageContext.setAttribute("greeting","Good Morning");
request.setAttribute("wrycry","hows the josh ");
application.setAttribute("proverb","work while u work and play while u play");
session.setAttribute("country","India");
%>

page level = <%= pageContext.getAttribute("greeting") %>
<br>
application level =<%=application.getAttribute("proverb") %>
<br>
request level =<%=request.getAttribute("wrycry") %>
<br>
session level =<%=session.getAttribute("country") %>



<br>------------------------------

<jsp:include page="ELex.jsp"  />

</body>
</html>