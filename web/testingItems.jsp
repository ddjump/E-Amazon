<%--
  Created by IntelliJ IDEA.
  User: ddjump
  Date: 12/4/17
  Time: 3:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TESTING ITEMS</title>
</head>
<body>

<div class="container">
    <form id="contact" action="http://localhost:8080/AddItem" method="post">
        <h3>Add an Item</h3>
        <fieldset>
            <input name="articleName" placeholder="articleName" type="text" tabindex="1" required autofocus>
        </fieldset>
        <fieldset>
            <input name="seller" placeholder="seller" type="text" tabindex="2" required>
        </fieldset>
        <fieldset>
            <input name="nameItem" placeholder="nameItem" type="text" tabindex="3" required>
        </fieldset>
        </fieldset>
        <fieldset>
            <input name="category" placeholder="category" type="text" tabindex="4" required>
        </fieldset>
        <fieldset>
            <input name="description" placeholder="description" type="text" tabindex="5" required>
        </fieldset>
        <fieldset>
            <input name="price" placeholder="price" type="text" tabindex="6" required>
        </fieldset>
        <fieldset>
            <input name="quantity" placeholder="quantity" type="text" tabindex="6" required>
        </fieldset>

        <fieldset>
            <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Submit</button>
        </fieldset>
    </form>

    <form id="deleteItem" action="http://localhost:8080/DeleteItem" method="post">
        <h3>Delete an Item</h3>
        <fieldset>
            <input name="articleId" placeholder="Item ID" type="text" tabindex="1" required autofocus>
        </fieldset>
    </form>

</div>


</body>
</html>