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
    <link rel="stylesheet" href="css/testcss.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class = "nav">
    <ul>
        <li><a href ="Home.jsp">Home</a></li>
        <li><a href ="ViewCustomer.jsp">Profile</a></li>
        <li><a href ="http://localhost:8080/GetAllItems">Shop</a></li>
        <li><a href ="CustomerCart.jsp">My Cart</a></li>
        <li><a href ="http://localhost:8080/Logout">Sign Out</a></li>

        <li>
        </ul>
</div>

<form id="contact" action="EditCustomer.jsp" method="post">
    <h3>MY PROFILE</h3>
    <fieldset>
        <h4>Your name is</h4>
        <h4>${customer.id}</h4>
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
        <h4>${customer.email}</h4>
    </fieldset>
    <fieldset>
        <h4>Username</h4>
        <h4>${customer.username}</h4>
    </fieldset>
    <fieldset>
        <h4>Password</h4>
        <h4>${customer.password}</h4>
    </fieldset>

    <fieldset>
        <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Edit</button>
    </fieldset>

</form>
</body>
</html>
