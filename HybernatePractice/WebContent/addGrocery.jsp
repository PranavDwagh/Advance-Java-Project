<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="AddProduct" method="post">
Enter product ID : <input type="number" name="id"/><br><br>
Enter product Name : <input type="text" name="name"/><br><br>
Enter product Cost : <input type="number" name="cost"/><br><br>
Enter product Description : <input type="text" name="description"/><br><br>
Enter product unit : <input type="text" name="unit"/><br><br>
Enter product Expiry Date : <input type="date" name="date"/><br><br>

<input type="submit" value= "SUBMIT"/>

</form>
</body>
</html>