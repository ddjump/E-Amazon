<%--
  Created by IntelliJ IDEA.
  User: reaganyuan
  Date: 12/5/17
  Time: 4:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

    <link rel="stylesheet" href="/css/testcss.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class = "nav">
    <ul>
        <li><a href ="EmployeeHome.jsp">Home</a></li>
        <li><a href ="ViewEmployee.jsp">Your Profile</a></li>
        <li><a href ="getCustomer.jsp">Search Customer</a></li>
        <li><a href ="AddItem.jsp">Add Item</a></li>
        <li><a href ="DeleteItem.jsp">Delete Item</a></li>
        <li><a href ="http://localhost:8080/GetAllItems">All Items</a></li>
        <li><a href ="EditItem.jsp">Edit Items</a></li>
        <li><a href = "getEmployee.jsp" >  ${employee.role == 'manager' ? 'Search(boss) Employee' : ''}</a ></li>
        <li><a href ="BossEditEmployee.jsp">  ${employee.role == 'manager' ? 'Edit(boss) Employee' : ''}</a></li>
        <li><a href ="BossDeleteEmployee.jsp">  ${employee.role == 'manager' ? 'Delete(boss) Employee' : ''}</a></li>
        <li><a href ="/AddEmployee.jsp"> ${employee.role == 'manager' ? 'Add(boss) Employee' : ''}</a></li>
    </ul>

</div>

<form id="contact" action="http://localhost:8080/EditSelfEmployee" method="post">
    <h3>MY PROFILE</h3>
    <fieldset>
        <input name="employeeid" value="${employee.id}" type="text" tabindex="1" required>
    </fieldset>
    <fieldset>
        <input name="firstname" value="${person.firstname}"placeholder="articleName" type="text" tabindex="2" required autofocus>
    </fieldset>
    <fieldset>
        <input name="lastname" value="${person.lastname}"placeholder="seller" type="text" tabindex="3" required>
    </fieldset>
    <fieldset>
        <input name="dob" value="${person.dob}"placeholder="nameItem" type="text" tabindex="4" required>
    </fieldset>
    </fieldset>
    <fieldset>
        <input name="address" value="${person.address}"placeholder="category" type="text" tabindex="5" required>
    </fieldset>
    <fieldset>
        <input name="city" value="${person.city}"placeholder="description" type="text" tabindex="6" required>
    </fieldset>
    <fieldset>
        <input name="zipcode" value="${person.zipcode}"placeholder="zipcode" type="text" tabindex="7" required>
    </fieldset>
    <fieldset>
        <input name="country" value="${person.country}"placeholder="country" type="text" tabindex="8" required>
    </fieldset>
    <fieldset>
        <input name="username" value="${employee.username}"placeholder="username" type="text" tabindex="10" required>
    </fieldset>
    <fieldset>
        <input name="password" value="${employee.password}"placeholder="password" type="text" tabindex="11" required>
    </fieldset>
    <fieldset>
        <input name="datejoined" value="${employee.datejoined}"placeholder="datejoined" type="text" tabindex="11" required>
    </fieldset>
    <fieldset>
        <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Submit</button>
    </fieldset>
</form>
</body>
</html>
