<%@page import="pojo_DAO_DO.BookDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pojo_DAO_DO.BookPojo"%>
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
<form>
	
	Click below to Get All Book Details
	<input type="text" name="input"><br><br>
	<input type="submit"  value="Click Here"/>
</form>
<% 
	String input = request.getParameter("input"); 
	
	if(input != null)
	{
		List<BookPojo> list = new ArrayList<BookPojo>();
		
		BookDAO dao = new BookDAO();
		list = dao.getAllBook();
		for(int i=0; i<list.size();i++)
		{%>
		<%=list.get(i).getBook_id() %>
		<%=list.get(i).getBook_cost() %>
		<%=list.get(i).getBook_name() %><br>
		<%}
	}
	else
	{%>
		<%="Nothing in input" %>
	<%}
%>
	


</body>
</html>