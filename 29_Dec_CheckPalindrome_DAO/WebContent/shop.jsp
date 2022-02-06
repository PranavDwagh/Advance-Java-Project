<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
Select products:
<select name=product>
<option value = "mobile">Mobile</option>
<option value = "Laptop">Laptop</option>
<option value = "PS5">PS5</option>
<option value = "bike">Bike</option>
<option car = "car">Car</option>

</select>

<input type="submit" value="Add To Cart"/>
</form>

<%

String product = request.getParameter("product");
//System.out.println("your prod"+product);
//System.out.println(session.isNew());

if(product != null)
{
	
	if(session.isNew())
	{

		session.setAttribute("list", new ArrayList<String>());
		 
		
	}
	else
	{
		ArrayList<String> list = (ArrayList<String>)session.getAttribute("list");
		if(list != null)
		list.add(product);
		else
		list = new ArrayList<String>();
		
		session.setAttribute("list", list);
		
		list.forEach(System.out::println);
	}
}


%>

</body>
</html>