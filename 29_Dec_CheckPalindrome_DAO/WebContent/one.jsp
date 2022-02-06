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
	String input = request.getParameter("input");
	if(input != null)
	{%>
		<h3><font color="red"><%=input %> not allowed</font></h3>
	<%}%>

<form action = "check_palindrome.jsp">
ENTER STRING : <input type="text" name = "input"/>
<br><br>	

<input type="submit" value ="check"/>

</form>

</body>
</html>