<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html>

<body>

<h2>Information about employee</h2>

<br>
<br>

<%--Your name: ${param.employeeName}--%>
Your name: ${employee.name}
<br>
Your surname: ${employee.surname}
<br>
Your salary: ${employee.salary}
<br>
Your department: ${employee.department}
<br>
Your car: ${employee.carBrand}
<br>
Language(s):
<ul>

    <jsp:useBean id="employee" scope="request" type="ru.darlyn.springMVC.Employee"/>
    <c:forEach var="lang" items="${employee.languages}">

        <li>   ${lang}    </li>

    </c:forEach>

</ul>
<br>
Phone number: ${employee.phoneNumber}
<br>
Email: ${employee.email}
</body>

</html>