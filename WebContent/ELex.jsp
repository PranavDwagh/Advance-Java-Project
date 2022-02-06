<%@page import="study.RandomNumber"%>

<html>
<body>
<h1>ELex.jsp</h1>


<br>
application level = ${applicationScope.proverb}
<br>
request level = ${wrycry}
<br>
session level = ${sessionScope.country}
<br>
application = ${applicationScope.random.getRandomNumber() }
</body>
</html>