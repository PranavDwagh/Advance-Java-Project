<%@page import="java.sql.SQLException"%>
<%@ page  contentType="text/html; charset=ISO-8859-1"
     errorPage="error.jsp" isErrorPage="false"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if(1<2){
throw new SQLException();
}
%>

HELLO
</body>
</html>