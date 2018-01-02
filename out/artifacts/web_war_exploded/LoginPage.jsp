<%--
  Created by IntelliJ IDEA.
  User: reaganyuan
  Date: 12/5/17
  Time: 4:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <font size="30" color= #660000><center>Login Page</center></font>
    <link rel="stylesheet" href="/css/testcss.css">
</head>
<title>Search box with Navigation Bar</title>

<body>
<div class = "nav">
    <ul>
        <li><a href ="home.html">HOME</a></li>
        <li><a href ="search.html">LINKS</a></li>
        <li><a href ="update.html">PRODUCTS</a></li>
        <li><a href ="edit.html">EVENT</a></li>
        <li><a href ="five.html">NEWS</a></li>
        <li><a href ="six.html">CAREER</a></li>

        <li>
            <div class="search">
                <input type="text" class="searchTerm" placeholder="What are you looking for?">
                <button type="submit" class="searchButton">
                    <i class="fa fa-search"></i>
                </button>
            </div>
        </li>
</ul>

</div>

<form action="http://localhost:8080/Login" method="'post" align="center">
    <div class="imgcontainer">
        <!-- <img src="img_avatar2.png" alt="Avatar" class="avatar"> -->
    </div>

    <div class="container">
        <label><b> Username </b></label>
        <input type="text" placeholder="Enter Username" name="uname" required>
<br>
        <label><b> Password </b></label>
        <input type="password" placeholder="Enter Password" name="psw" required>
<br>
        <button type="submit">Login</button>
        <input type="checkbox" checked="checked"> Remember me
    </div>

    <div class="container" style="background-color:#f1f1f1">
        <input type="button" class="cancelbtn" onclick="location.href='index.jsp';" value="Sign Up" />
    </div>
</form>
</body>
</html>