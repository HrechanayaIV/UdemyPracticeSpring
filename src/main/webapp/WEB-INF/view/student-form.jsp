<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student page</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student">
    First name: <form:input path="firstName"/>
    <br><br>
    Last name: <form:input path="lastName"/>
    <br><br>
    Country:
    <form:select path="country">
        <form:option value="Ukraine" label="Ukraine"/>
        <form:option value="France" label="France"/>
        <form:option value="Germany" label="Germany"/>
    </form:select>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>