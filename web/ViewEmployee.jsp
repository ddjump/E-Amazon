<%--
  Created by IntelliJ IDEA.
  User: reaganyuan
  Date: 12/5/17
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
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
<form id="contact" action="EditEmployee.jsp" method="post">
    <h3>MY PROFILE</h3>
    <fieldset>
        <h4>Your ID</h4>
        <h4>${employee.id}</h4>
    </fieldset>
    </fieldset>
    <fieldset>
        <h4>First Name</h4>
        <h4>${person.firstname}</h4>
    </fieldset>
    <fieldset>
        <h4>Last Name</h4>
        <h4>${person.lastname}</h4>
    </fieldset>
    <fieldset>
        <h4>Date Of Birth</h4>
        <h4>${person.dob}</h4>
    </fieldset>
    </fieldset>
    <fieldset>
        <h4>Address</h4>
        <h4>${person.address}</h4>
    </fieldset>
    <fieldset>
        <h4>Zip Code</h4>
        <h4>${person.zipcode}</h4>
    </fieldset>
    <fieldset>
        <h4>Country</h4>
        <h4>${person.country}</h4>
    </fieldset>
    <fieldset>
        <h4>Email</h4>
        <h4>${employee.role}</h4>
    </fieldset>
    <fieldset>
        <h4>Salary</h4>
        <h4>${employee.salary}</h4>
    </fieldset>
    <fieldset>
        <h4>Supervisor ID</h4>
        <h4>${employee.supervisor_id}</h4>
    </fieldset>
    <fieldset>
        <h4>User Name</h4>
        <h4>${employee.username}</h4>
    </fieldset>
    <fieldset>
        <h4>Password</h4>
        <h4>${employee.password}</h4>
    </fieldset>
    <fieldset>
        <h4>Date Joined</h4>
        <h4>${employee.datejoined}</h4>
    </fieldset>
    <fieldset>
        <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Edit</button>
    </fieldset>

</form>
</body>
</html>