<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="AddGrocery" method = "post">

Enter Product_id <input type="number" name="id"/><br><br>
Enter Product_name <input type="text" name="name"/><br><br>
Enter Product_desc <input type="text" name="desc"/><br><br>
Enter Unit of Measurement <input type="text" name="unit"/><br><br>
Enter cost <input type="number" name="cost"/><br><br>
Enter Expiry Date <input type="text" name="date"/><br><br>

<input type="submit" value="Add Grocery"/>

</form>


</body>
</html>