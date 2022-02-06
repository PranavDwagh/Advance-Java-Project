<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
 <body>
        <form action="AddUser" method="get">          <!-- adduser.jsp to be written -->
            Enter ID : <input type="number" name="id"/>
            <br><br>
            Enter FirstName : <input type = "text" name="firstname">
            <br><br>
            Enter LastName: <input type = "text" name="lastname">
            <br><br>
            Enter Email: <input type = "text" name="email">
            <br><br>
            Enter username : <input type = "text" name="username">
            <br><br>
            Enter Password : <input type = "text" name="password">
            <br><br>
            <input type="submit" value = "Add User"/>
        </form>
    </body>
</html>