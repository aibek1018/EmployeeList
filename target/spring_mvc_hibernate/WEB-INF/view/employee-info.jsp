<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<body>

<h2> EMPLOYEE INFO </h2>

<br>

<form:form action="saveEmployee" modelAttribute="employee">

    <form:hidden path="id"/>

    Name <form:input path="name"/>
    <br> <br>
    Surname <form:input path="surname"/>
    <br> <br>
    Middle Name <form:input path="middleName"/>
    <br> <br>
    Phone Number <form:input path="phoneNumber"/>
    <br> <br>
    Email <form:input path="email"/>
    <br> <br>
    Country <form:input path="country"/>
    <br> <br>
    City <form:input path="city"/>
    <br> <br>
    <input type="submit" value="OK">

</form:form>


</body>

</html>