<%@ page import="com.softserve.itacademy.model.Task" %>
<%@ page import="com.softserve.itacademy.controller.ReadTaskServlet" %>
<%@ page import="javax.servlet.annotation.WebServlet" %>
<%@ page import="com.softserve.itacademy.controller.TasksListServlet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>

    <style>
        <%@include file="../styles/main.css"%>
    </style>

</head>
<body>
    <%@include file="header.html"%>
    <h2>Task with ID '<%=request.getParameter("id")%>' not found in To-Do List!</h2>
    <h3>url: <%=request.getAttribute("pageURL")%></h3>
</body>
</html>
