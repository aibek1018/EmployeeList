<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<%--    <script src="../js/jquery-3.6.0.js"></script>--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.inputmask/3.3.4/jquery.inputmask.bundle.min.js"></script>
    <title>Add employee</title>
</head>

<body>

<h2> EMPLOYEE INFO </h2>

<br>

<form:form action="saveEmployee" id="form" modelAttribute="employee">

    <form:hidden path="id"/>

    Name <form:input required="required" path="name"/>
    <br> <br>
    Surname <form:input required="required" path="surname"/>
    <br> <br>
    Middle Name <form:input required="required" path="middleName"/>
    <br> <br>
    Phone Number <form:input minlength="11" id="phone" required="required" path="phoneNumber"/>
    <br> <br>
    Email <form:input id="email" required="required" path="email"/>
    <br> <br>

    Country
    <form:select id="country" name="country" path="country.id" onchange="getCities(this.options[this.selectedIndex].value)"> <!-- onchange="getCities(this.options[this.selectedIndex].value)" -->
        <c:forEach items="${countries}" var="country">
            <option value="${country.id}" ${employee.country.id == country.id ? 'selected' : ''}>${country.name}</option>
        </c:forEach>
    </form:select>
    <br/><br/>

    City
    <form:select id="city" name="city" path="city.id" onchange="setFormValue(this.options[this.selectedIndex].value)">
        <c:forEach items="${cities}" var="city">
            <option value="${city.id}" ${employee.city.id == city.id ? 'selected' : ''}>${city.name}</option>
        </c:forEach>
    </form:select>
    <br/><br/>
    <input id="submit" type="button" value="OK">
</form:form>


</body>

</html>

<script>
    function getCities(value) {
        $.ajax({
            type: "GET",
            url: "${pageContext.request.contextPath}/getCities?id=" + value,
            headers: {"Accept": "text/html,application/json"},
            success: function (response) {
                $("#city").empty();
                $.each(response,function(key, value)
                {
                    $("#city").append('<option value=' + value["id"] + '>' + value["name"] + '</option>');
                });
            }
        });
    }

    function setFormValue(value){

        if(!value){
            value = $("#city option:selected").val();
        }
        $("#form").attr("city.id", value);
    }



    $(document).ready(function() {
        getCities($("#country option:selected").val());
        setFormValue(null);
        $("#phone").inputmask('9 (999) 999-99-99');
    });

    $(document).on("click","#submit",function(event){
        var phone = $("#phone").val()
        if(phone.slice(phone.length - 1)!=='_'){
            if(isValidEmail()===true){
                var data = $("#form").serialize();

                $.ajax({
                    type: "POST",
                    data: data,
                    url: "${pageContext.request.contextPath}/saveEmployee",
                    headers: {"Accept": "text/html,application/json"},
                    success: function (response) {
                        window.location.href='/EmployeeList_war'
                    }
                });
            }
            else{
                alert("Invalid email!");
            }
        } else{
            alert("Invalid number!");
        }


    });

    function isValidEmail(){
        var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        return regex.test($("#email").val());
    }

</script>