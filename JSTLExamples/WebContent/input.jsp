<%@page import="org.apache.catalina.ant.SessionsTask"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
Enter Name : <input type="text" name = "name"/>
<br>
<input type="submit" value = "insert"/> 
</form>
<%
String name = request.getParameter("name");

//if(name != null)
{
	if(session.isNew())
	{
		session.setAttribute("list",new ArrayList<String>());
	}
	else
	{
		ArrayList<String> list = (ArrayList)session.getAttribute("list");
		
		if (name != null)
		{
			list.add(name);
		}
		session.setAttribute("list", list);   // setting session attribute to new list again
		request.setAttribute("name", list);    // setting request scope
		
	}
}

%>

<c:forEach var="x" items="${name }">
<%-- <h1><c:out value="${x}" /></h1> --%>

<c:if test="${x.length()<5 }">
	<h1><c:out value="${x.toUpperCase() }"/></h1>
</c:if>
<c:if test="${x.length()>5 }">
	<h1><c:out value="${x }"/></h1>
</c:if>

</c:forEach>



</body>
</html>