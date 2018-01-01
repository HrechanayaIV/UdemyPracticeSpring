<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h2>Luv2code company Home page</h2>
<br><br>
<p>
Welcome to the luv2code company home page!
</p>
<!-- add a logout button !-->
<
<form:form action="${pageContext.request.contextPath}/logout"
      method="post">
    <input type="submit" value="Logout"/>
</form:form>
</body>
</html>
