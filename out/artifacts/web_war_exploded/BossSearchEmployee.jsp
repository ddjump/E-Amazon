<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <font size="30" color= #660000><center>Welcome to Emazon</center></font>

    <link rel="stylesheet" href="/css/testcss.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
<div class = "nav">
    <ul>
        <li><a href ="EmployeeHome.jsp">Home</a></li>
    </ul>

</div>
<form id="contact" action="EditEmployee.jsp" method="post">
    <h3>EMPLOYEE</h3>
    <fieldset>
        <h4>Employee ID</h4>
        <h4>${e.id}</h4>
    </fieldset>
    </fieldset>
    <fieldset>
        <h4>First Name</h4>
        <h4>${p.firstname}</h4>
    </fieldset>
    <fieldset>
        <h4>Last Name</h4>
        <h4>${p.lastname}</h4>
    </fieldset>
    <fieldset>
        <h4>Date Of Birth</h4>
        <h4>${p.dob}</h4>
    </fieldset>
    </fieldset>
    <fieldset>
        <h4>Address</h4>
        <h4>${p.address}</h4>
    </fieldset>
    <fieldset>
        <h4>Zip Code</h4>
        <h4>${p.zipcode}</h4>
    </fieldset>
    <fieldset>
        <h4>Country</h4>
        <h4>${p.country}</h4>
    </fieldset>
    <fieldset>
        <h4>Email</h4>
        <h4>${e.role}</h4>
    </fieldset>
    <fieldset>
        <h4>Salary</h4>
        <h4>${e.salary}</h4>
    </fieldset>
    <fieldset>
        <h4>Supervisor ID</h4>
        <h4>${e.supervisor_id}</h4>
    </fieldset>
    <fieldset>
        <h4>User Name</h4>
        <h4>${e.username}</h4>
    </fieldset>
    <fieldset>
        <h4>Password</h4>
        <h4>${e.password}</h4>
    </fieldset>
    <fieldset>
        <h4>Date Joined</h4>
        <h4>${e.datejoined}</h4>
    </fieldset>

</form>
</body>
</html>