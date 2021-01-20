<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head><title>MyServlet</title></head>
<body>
<table border="2" bgcolor="#FFFFFF" width="400">
    <tr>
        <th>Data</th>
        <th>Amount of money</th>
        <th>Receiver</th>
    </tr>
    <c:forEach items="${data}" var="item">
        <tr>
            <td>${item.paydate}</td>
            <td>${item.value}</td>
            <td>${item.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>



