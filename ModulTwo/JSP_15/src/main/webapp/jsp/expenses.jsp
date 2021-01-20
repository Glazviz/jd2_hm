<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head><title>MyServlet</title></head>
<body>
<c:forEach var="user" items="${data}">
    <li><c:out value="${user}"/></li>
</c:forEach>
</body>
</html>


<%--
Задание 15

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="servlet.JSPServlet" %>

<html>
<head><title>MyServlet</title></head>
<body>
<%
    ArrayList<String> list = (ArrayList<String>) request.getAttribute("data");
    for (String s : list) {
        out.println(s + "<br/>");
    }
%>
</body>
</html>
--%>


