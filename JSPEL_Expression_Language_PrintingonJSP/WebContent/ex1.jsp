<%@page import="random.RandomNumber"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>this is ex1</h2>
	<%
		pageContext.setAttribute("Greetings", "This is pageContext->");
		application.setAttribute("Greetings2", "<-This is application level");
		session.setAttribute("Greetings3", "<-this is session...its valid till this session...->");
		request.setAttribute("Greetings4", "<-this is request->");
		RandomNumber rn = new RandomNumber(50);
		application.setAttribute("random", rn );
		
	%>
	<%=pageContext.getAttribute("Greetings") %> <br> <!-- valid till this page   -->
	<%=application.getAttribute("Greetings2") %><br>  <!-- valid till this application exists  widest scope...alive till wed context undeployment -->
	<%=session.getAttribute("Greetings3")%><br>		<!-- valid till this session invalidate -->
	
	<%=request.getAttribute("Greeting4") %>
	<br>
	application = <%=((RandomNumber)application.getAttribute("random")).getRandomNumber()  %>
	
	<jsp:include page="EL1.jsp"/>

</body>
</html>