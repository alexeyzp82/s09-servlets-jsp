<%@ page import="com.softserve.itacademy.model.Task" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Tasks</title>

    <style>
        <%@include file="../styles/main.css"%>
    </style>

</head>
<body>
<%@include file="header.html" %>
<h2>List of Tasks</h2>
<table>
    <tr>
        <th>No.</th>
        <th>Name</th>
        <th colspan="3">Priority</th>
    </tr>

    <%
        for (Task task : (List<Task>) request.getAttribute("tasks")) {
    %>
    <div>
        <tr>
            <td><%=task.getId()%>
            </td>
            <td><%=task.getTitle()%>
            </td>
            <td>
                <a href="read-task.jsp?id= <%=task.getId()%>">Read</a>
            </td>
            <td>
                <a href="update-task.jsp?id= <%=task.getId()%>">Edit</a>
            </td>
            <td>
                <a href="delete-task.jsp?id= <%=task.getId()%>">Delete</a>
            </td>
        </tr>
    </div>
    <%
        }
    %>
</table>
</body>
</html>
