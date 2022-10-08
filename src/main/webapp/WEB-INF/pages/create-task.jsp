<%@ page import="com.softserve.itacademy.model.Priority" %>
<%@ page import="com.softserve.itacademy.model.Task" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new Task</title>

    <style>
        <%@include file="../styles/main.css"%>
    </style>

</head>
<body>
<%@include file="header.html" %>
<h2>Create new Task</h2>
<form method="post">
    <div>
        <label for="title">Name: </label>
        <input name="title" id="title">
    </div>
    <div>
        <label for="priority">Priority: </label>
        <select name="priority" id="priority">
            <%
                for (Priority priority : Priority.values()) {
            %>
            <option name=<%=priority.name()%>><%=priority.info()%></option>
            <%
                }
            %>
        </select>
    </div>
    <div>
        <button type="submit">Create</button>
        <button type="reset">Clear</button>
    </div>
</form>

</body>
</html>
