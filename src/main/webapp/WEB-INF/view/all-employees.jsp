<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<body>

<h2> LIST OF EMPLOYEES </h2>
<br>

<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Middle Name</th>
        <th>Phone Number</th>
        <th>Email</th>
        <th>Country</th>
        <th>City</th>
        <th>Operations</th>
    </tr>

    <c:forEach var="emp" items="${allEmps}">

        <c:url var="updateButton" value="/updateInfo">
            <c:param name="empId" value="${emp.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/deleteEmployee">
            <c:param name="empId" value="${emp.id}"/>
        </c:url>

        <tr>
            <td>${emp.name}</td>
            <td>${emp.surname}</td>
            <td>${emp.middleName}</td>
            <td>${emp.phoneNumber}</td>
            <td>${emp.email}</td>
            <td>${emp.country.name}</td>
            <td>${emp.city.name}</td>
            <td>
                <input type="button" value="Update"
                       onclick="window.location.href='${updateButton}'"/>

                <input type="button" value="Delete"
                       onclick="window.location.href='${deleteButton}'"/>
            </td>
        </tr>

    </c:forEach>

</table>
<br>
<br>

<form action="${pageContext.request.contextPath}/search" method="GET">
    Enter your surname: <input id="surname" type="text" name="surname">
    <input type="submit" value="Search">
</form>

<br>
<input type="button" value="Add"
       onclick="window.location.href='addNewEmployee'"/>

</body>

</html>