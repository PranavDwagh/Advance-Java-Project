<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%
 	List<String> list = Arrays.asList("red","green","blue","yellow");
 
 	request.setAttribute("colors",list);

 %>


   ${colors}
   ${colors[1] }
   
   ${3}
   <br>
   ${4 > 2 }
   <br>
   ${ 4+2 }
   
   
 <table>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach items="${colors}" var="col">  
  <tr> 
    <td>${col.toUpperCase()}</td> 
      </tr> 
</c:forEach>
</table>
 
  
</body>
</html>