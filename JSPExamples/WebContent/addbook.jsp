<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method=post> <!-- no action means - ON submit come to same page -->
	
	<input type="number"  name="id"/>
	<input type="number"  name="cost"/>
	<input type="text"  name="name"/>
	<input type="submit"  value ="ok"  />

</form>
<%
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String cost = request.getParameter("cost");

	if(id!=null)
	{
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbc_url = "jdbc:mysql://localhost:3306/bookshop";
		String uname ="root";
		String pass= "123456789";
		
		Connection con = DriverManager.getConnection(jdbc_url, uname, pass);
		System.out.println("connection to DB is successful "+con);
		
		String sql = "insert into book values(?,?,?)"; 
		//pstmt  is TIED UP with sql 
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		//the 1 is the position of the  ? = parameterIndex
		pstmt.setInt(1, Integer.parseInt(id));
		pstmt.setInt(2, Integer.parseInt(cost));
		pstmt.setString(3, name); //automatically if v
		 pstmt.executeUpdate();
		
		
		 
	} //end of if
  %>



</body>
</html>