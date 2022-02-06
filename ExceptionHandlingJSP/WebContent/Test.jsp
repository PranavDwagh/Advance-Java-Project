<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="MyErrro.jsp" isErrorPage="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>

Enter Number :<input type="text" name ="input"/>
<input type="submit" value="getSquare">
</form>

<%
 
String num = request.getParameter("input");
if(num != null)
{
	int number = Integer.parseInt(num);
	int sq = number*number;
	request.setAttribute("sq", sq);
	%>Square :<%=sq %>
<%}
%>
Square : ${sq }
</body>
</html>