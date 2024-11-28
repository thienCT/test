<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/28/2024
  Time: 6:56 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="com.example.playerevaluation.Entity.Player" %>
<%@ page import="com.example.playerevaluation.DAO.PlayerDAO" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    Player player = PlayerDAO.getPlayerById(id);
%>
<html>
<head>
    <title>Edit Player</title>
</head>
<body>
<h1>Edit Player</h1>
<form action="PlayerServlet" method="POST">
    <input type="hidden" name="id" value="<%= player.getId() %>">
    <label>Name:</label>
    <input type="text" name="name" value="<%= player.getName() %>" required>
    <label>Age:</label>
    <input type="number" name="age" value="<%= player.getAge() %>" required>
    <label>Position:</label>
    <input type="text" name="position" value="<%= player.getPosition() %>" required>
    <label>Team:</label>
    <input type="text" name="team" value="<%= player.getTeam() %>" required>
    <button type="submit" name="action" value="update">Update Player</button>
</form>
</body>
</html>

