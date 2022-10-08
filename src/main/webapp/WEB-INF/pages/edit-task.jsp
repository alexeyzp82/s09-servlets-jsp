<%@ page import="com.softserve.itacademy.model.Task" %>
<%@ page import="com.softserve.itacademy.model.Priority" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit existing Task</title>

    <style>
        <%@include file="../styles/main.css"%>
    </style>

</head>
<body>
<%@include file="header.html" %>
<h2>Edit existing Task</h2>

<%
    Task task = (Task) request.getAttribute("task");
%>

<form method="post">
    <div>
        <label for="id">Id: </label>
        <input name="id" id="id" value="<%=task.getId()%>" disabled>
    </div>
    <div>
        <label for="title">Name: </label>
        <input name="title" id="title" value="<%=task.getTitle()%>">
    </div>
    <div>
        <label for="priority">Priority: </label>
        <select name="priority" id="priority">
            <%
                for (Priority priority : Priority.values()) {
                    String add = priority == task.getPriority() ? " selected" : "";
            %>
            <option name=<%=(priority.name())%> <%=add%>><%=priority.info()%>
            </option>
            <%
                }
            %>
        </select>
    </div>
    <div>
        <button type="submit">Update</button>
        <button type="reset">Clear</button>
    </div>
</form>


</body>
</html>
