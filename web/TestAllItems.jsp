<%--
  Created by IntelliJ IDEA.
  User: reaganyuan
  Date: 12/5/17
  Time: 7:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>TESTING ALL ITEMS</title>
</head>
<body>
<h4>PRINTING ITEMS</h4>


<table BORDER="1">
    <tbody>
    <c:forEach items="${i}" var="k">
        <tr>

                <td><c:out value="${k.seller}"/></td>
                <td><c:out value="${k.articleid}"/></td>


        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
