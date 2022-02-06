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
Enter number <input type="number" name = "num"/>

<input type="submit" value ="get Hello"/>

<a href="input.jsp">go to input</a>

</form>

	<%String v = request.getParameter("num");
	
	if( v != null)
	{
		int x = Integer.parseInt(v);
		for(int i=0; i<x ; i++) {%>
			<p> <%=i %>Hello </p>		
		<%}
	}
	%>

</body>
</html>