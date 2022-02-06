<%@page import="study.entity.GroceryEntity"%>
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
GroceryEntity obj = (GroceryEntity)session.getAttribute("grocery");
//request.setAttribute("obj", obj);
	//if(obj==null)
	//System.out.println("obj is null!!!");
	if(obj!=null)
	{%>
		<table border="2px">
		<tr>
		<td><%=obj.getId() %></td>
		<td><%=obj.getName() %></td>
		<td><%=obj.getCost() %></td>
		<td><%=obj.getDescription() %></td>
		<td><%=obj.getUnit() %></td>
		<td><%=obj.getDate() %></td>
		</tr>
		</table>
	<%}
	%>

<form action="viewProduct">
Enter Product ID: <input type="number" name="id">
<input type="submit" value="View Product"/>
</form>
<form action="Welcome.html">
<input type="submit" value="Go to Welcome"/>
</form>
</body>
</html>