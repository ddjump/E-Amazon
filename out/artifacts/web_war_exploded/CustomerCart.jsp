
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

    <link rel="stylesheet" href="/css/testcss.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<title>Search box with Navigation Bar</title>

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
<br>
<br>


<h4></h4>
<table BORDER="1">
    <tbody>
    <table style="width:40%">
        <tr>
            <th>Item ID</th>
            <th>Seller</th>
            <th>Item Name</th>
            <th>Category</th>
            <th>Description</th>
            <th>Price</th>
            <th>Items Left</th>


        </tr>
        <c:forEach items="${shoppingcart}" var="k">
            <tr>
                <br/>
                <td>${k.articleid}</td>
                <td>${k.seller}</td>
                <td>${k.itemname}</td>
                <td>${k.category}</td>
                <td>${k.desciption}</td>
                <td>${k.price}</td>
                <td>${k.quantity}</td>
            </tr>
        </c:forEach>


    </table>
    </tbody>
</table>
<br>
<br>

    <h4>Total Price: $${totalprice}</h4>
<form action="CheckOut.jsp" method="post" style="border:none">
    <button name="submit" type="submit" id="contact-submit" style="border:none" data-submit="...Sending">CheckOut</button>
    <form>

</body>
</html>