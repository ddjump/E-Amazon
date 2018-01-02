<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <font size="30" color= #660000><center>Welcome to Emazon</center></font><a href="login.html">Login</a>

    <link rel="stylesheet" href="/css/testcss.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class = "nav">
    <ul>
        <li><a href ="EmployeeHome.jsp">Home</a></li>
        <li><a href ="ViewEmployee.jsp">Your Profile</a></li>
        <li><a href ="getCustomer.jsp">Search Customer</a></li>
        <li><a href ="http://localhost:8080/GetAllItems">All ITEMS</a></li>
        <li><a href = "getEmployee.jsp" >  ${employee.role == 'manager' ? 'Search(boss) Employee' : ''}</a ></li>
        <li><a href ="BossEditEmployee.jsp">  ${employee.role == 'manager' ? 'Edit(boss) Employee' : ''}</a></li>
        <li><a href ="BossDeleteEmployee.jsp">  ${employee.role == 'manager' ? 'Delete(boss) Employee' : ''}</a></li>
        <li><a href ="/AddEmployee.jsp"> ${employee.role == 'manager' ? 'Add(boss) Employee' : ''}</a></li>
    </ul>

</div>

<form id="contact" action="http://localhost:8080/BossEditEmployee2" method="post">
    <h3>MY PROFILE</h3>
    <fieldset>
        <input name="employeeid" value="${storeEmployee.id}" type="ID" tabindex="1" required>
    </fieldset>
    <fieldset>
        <input name="firstname" value="${storePerson.firstname}"placeholder="First Name" type="text" tabindex="2" required autofocus>
    </fieldset>
    <fieldset>
        <input name="lastname" value="${storePerson.lastname}"placeholder="Last Name" type="text" tabindex="3" required>
    </fieldset>
    <fieldset>
        <input name="dob" value="${storePerson.dob}"placeholder="Dob" type="text" tabindex="4" required>
    </fieldset>
    </fieldset>
    <fieldset>
        <input name="address" value="${storePerson.address}"placeholder="category" type="text" tabindex="5" required>
    </fieldset>
    <fieldset>
        <input name="city" value="${storePerson.city}"placeholder="description" type="text" tabindex="6" required>
    </fieldset>
    <fieldset>
        <input name="zipcode" value="${storePerson.zipcode}"placeholder="zipcode" type="text" tabindex="7" required>
    </fieldset>
    <fieldset>
        <input name="country" value="${storePerson.country}"placeholder="country" type="text" tabindex="8" required>
    </fieldset>
    <fieldset>
        <input name="username" value="${storeEmployee.username}"placeholder="username" type="text" tabindex="10" required>
    </fieldset>
    <fieldset>
        <input name="password" value="${storeEmployee.password}"placeholder="password" type="text" tabindex="11" required>
    </fieldset>

    <fieldset>
        <input name="role" value="${storeEmployee.role}"placeholder="password" type="text" tabindex="11" required>
    </fieldset>
    <fieldset>
        <input name="salary" value="${storeEmployee.salary}"placeholder="Salary" type="text" tabindex="11" required>
    </fieldset>
    <fieldset>
        <input name="datejoined" value="${storeEmployee.datejoined}"placeholder="Date Joined" type="text" tabindex="11" required>
    </fieldset>
    <fieldset>
        <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Submit</button>
    </fieldset>
</form>
</body>
</html>
