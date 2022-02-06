<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
</head>
<body>
<h1>EL1.jsp</h1>
<br>
application scope = ${applicationScope.Greetings2 }<br>

request scope = ${Greetings4 }
<br>
session scope = ${sessionScope.Greetings3 }
<br>
page Scope  =${pageScope.Greetings4 }

</body>
</html>