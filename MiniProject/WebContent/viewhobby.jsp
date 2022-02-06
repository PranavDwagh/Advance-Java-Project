<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.java.miniproject.pojo.User"%>

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
<br>
Welcome <%=user_name%>..!!
<br>

<!-- <form action="viewHobby">
	
<input type="submit" value="Get Hobbies"/> 

</form> -->
 
<%
ArrayList<String> list = (ArrayList<String>)session.getAttribute("getHobby");

for(int i=0; i<list.size();i++)
{
	String str = list.get(i);
	%><h3><%=str %></h3>
<%}

%>

</body>
</html>