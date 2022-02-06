<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Random"%>

<html>
<body>
<%
List<String> al = Arrays.asList("alpha","beta","theta");
request.setAttribute("list",al); %>

<%request.setAttribute("num",new Random()); %>
<% pageContext.setAttribute("song4","daffodils"); %>
<% application.setAttribute("song3","zindagi ka safar hai ye kaisa safar"); %>
<% request.setAttribute("song","country roads take me home"); %>
<% session.setAttribute("song2","k sera sera whatever will be will be"); %>
${song}
<br>
${sessionScope.song2 }
<br>
${applicationScope.song3 }
<br>
${pageScope.song4 }
<br>
${requestScope.num.nextInt(100)}
<br>
${list[1]}
<table>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach items="${list}" var="element">  
  <tr> 
    <td>${element}</td> 
      </tr> 
</c:forEach>
</table>



</body>
</html>