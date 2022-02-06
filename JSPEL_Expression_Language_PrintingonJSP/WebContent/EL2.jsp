<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
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
	List<String> list = Arrays.asList("red", "green", "blue");
	request.setAttribute("colors", list);
	String str = "this is string object";
	
	pageContext.setAttribute("String", str);
%>

${colors }

${colors[1] }

${3 }

${"String" }

${pageScope.String }
</body>
</html>