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
        <li><a href ="http://localhost:8080/Logout">Logout</a></li>
    </ul>

</div>
<br>

<div class="img">
    <a target="_blank" href="fakepage.html">
        <img src="E:\Websites\MSA Website\files\images\Graduation2016.jpg" alt="Trolltunga Norway" width="300" height="200">
    </a>
    <div class="desc">Add a description of the image here</div>
</div>

<div class="img">
    <a target="_blank" href="fakepage.html">
        <img src="E:\Websites\MSA Website\files\images\Graduation2016.jpg" alt="Trolltunga Norway" width="300" height="200">
    </a>
    <div class="desc">Add a description of the image here</div>
</div>

<div class="img">
    <a target="_blank" href="fakepage.html">
        <img src="E:\Websites\MSA Website\files\images\Graduation2016.jpg" alt="Trolltunga Norway" width="300" height="200">
    </a>
    <div class="desc">Add a description of the image here</div>
</div>

<div class="img">
    <a target="_blank" href="fakepage.html">
        <img src="E:\Websites\MSA Website\files\images\Graduation2016.jpg" alt="Trolltunga Norway" width="300" height="200">
    </a>
    <div class="desc">Add a description of the image here</div>
</div>

<div class="img">
    <a target="_blank" href="fakepage.html">
        <img src="E:\Websites\MSA Website\files\images\Graduation2016.jpg" alt="Trolltunga Norway" width="300" height="200">
    </a>
    <div class="desc">Add a description of the image here</div>
</div>

<div class="img">
    <a target="_blank" href="fakepage.html">
        <img src="E:\Websites\MSA Website\files\images\Graduation2016.jpg" alt="Trolltunga Norway" width="300" height="200">
    </a>
    <div class="desc">Add a description of the image here</div>
</div>

<div class="img">
    <a target="_blank" href="fakepage.html">
        <img src="E:\Websites\MSA Website\files\images\Graduation2016.jpg" alt="Trolltunga Norway" width="300" height="200">
    </a>
    <div class="desc">Add a description of the image here</div>
</div>

<div class="img">
    <a target="_blank" href="fakepage.html">
        <img src="E:\Websites\MSA Website\files\images\Graduation2016.jpg" alt="Trolltunga Norway" width="300" height="200">
    </a>
    <div class="desc">Add a description of the image here</div>
</div>

<div class="img">
    <a target="_blank" href="fakepage.html">
        <img src="E:\Websites\MSA Website\files\images\Graduation2016.jpg" alt="Trolltunga Norway" width="300" height="200">
    </a>
    <div class="desc">Add a description of the image here</div>
</div>

<div class="img">
    <a target="_blank" href="fakepage.html">
        <img src="E:\Websites\MSA Website\files\images\Graduation2016.jpg" alt="Trolltunga Norway" width="300" height="200">
    </a>
    <div class="desc">Add a description of the image here</div>
</div>

<div class="img">
    <a target="_blank" href="fakepage.html">
        <img src="E:\Websites\MSA Website\files\images\Graduation2016.jpg" alt="Trolltunga Norway" width="300" height="200">
    </a>
    <div class="desc">Add a description of the image here</div>
</div>

</body>
</html>