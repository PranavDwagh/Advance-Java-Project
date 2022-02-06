<%@page import="java.util.List"%>
<%@page import="pojo_DAO_DO.BookPojo"%>
<%@page import="pojo_DAO_DO.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
	<form>
		ENTER BOOK ID : <input type="number" name="id" /> 
		<input type="submit" value="Get Book Details"/>
	</form>
	<%
  		String book_id = request.getParameter("id");
  		
  		if(book_id != null)
  		{
  			BookDAO obj = new BookDAO();
  			
  			BookPojo pojo = obj.getBookInfo(Integer.parseInt(book_id));
  		%>
		<%=pojo %>
		<%
		
		
	}
  %>
  	
  	
  

</body>
</html>