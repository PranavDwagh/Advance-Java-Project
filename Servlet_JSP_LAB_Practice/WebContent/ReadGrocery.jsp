<%@page import="com.grocery.pojo.Grocery"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="viewGrocery" method="GET">

Enter Grocery ID <input type="number" name = "id"/>


<input type="submit" value="Get Grocery"/>

</form>

<%
	Grocery gr = (Grocery)session.getAttribute("grocery");
	if(gr != null)
	{
	request.setAttribute("id", gr.getId());
	request.setAttribute("cost", gr.getCost());
	request.setAttribute("Dscription", gr.getDesc());
	request.setAttribute("ExpiryDate", gr.getExDate());
	request.setAttribute("Name", gr.getName());
	request.setAttribute("unit", gr.getUnit());
	

%>

<table border=2px>
<tr>
<td><b>product_id</b></td>
<td><b>cost</b></td>
<td><b>product_desc</b></td>
<td><b>Expiry_date</b></td>
<td><b>product_name</b></td>
<td><b>unit</b></td>

</tr>
<tr>
<td><b>${id }</b></td>
<td><b>${cost }</b></td>
<td><b>${Dscription }</b></td>
<td><b>${ExpiryDate }</b></td>
<td><b>${Name }</b></td>
<td><b>${unit}</b></td>

</tr>


</table>
<%
}
%>
</body>
</html>