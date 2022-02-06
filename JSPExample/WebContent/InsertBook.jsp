<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form  method = "get">
	
	Enter Book ID : <input type="number" name ="id"/>
	<br><br>
	Enter Book Cost : <input type="number" name ="cost" />
	<brr><br>
	Enter Book Name : <input type="text" name ="name"/>
	<br>
	<input type="submit" name="submit"/>
	</form>
	<%
	
	String id1 = request.getParameter("id");

	if(id1!=null)
	{
	int id = Integer.parseInt(id1); 
	String cost1 = request.getParameter("cost");
	int cost = Integer.parseInt(cost1); 
	String name = request.getParameter("name");
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop", "root", "9923140389");
	
	String sql = "insert into book values (?,?,?)";
	
	PreparedStatement pstmt = con.prepareStatement(sql);
	
	pstmt.setInt(1, id);
	pstmt.setInt(2, cost);
	pstmt.setString(3, name);
	
	pstmt.executeUpdate();
	
	response.getWriter().append("\nValues inserted into book");
	
	}
	%>
	

</body>
</html>