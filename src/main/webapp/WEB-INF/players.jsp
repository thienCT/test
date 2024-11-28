<%@ page import="com.example.playerevaluation.Entity.Player" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.playerevaluation.DAO.PlayerDAO" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/28/2024
  Time: 6:21 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Player Management</title>
</head>
<body>
<h1>Player Management</h1>

<form action="PlayerController" method="POST">

  <h3>Add New Player</h3>

  <label>Name:</label>
  <input type="text" name="name" required>
  <label>Age:</label>
  <input type="number" name="age" required>
  <label>Position:</label>
  <input type="text" name="position" required>
  <label>Team:</label>
  <input type="text" name="team" required>
  <button type="submit" name="action" value="add">Add Player</button>
</form>

<h3>Player List</h3>

<table border="1">
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Age</th>
    <th>Position</th>
    <th>Team</th>
    <th>Actions</th>
  </tr>

  <%
    List<Player> players = PlayerDAO.getAllPlayers();
    for (Player player : players) {
  %>
  <tr>
    <td><%= player.getId() %></td>
    <td><%= player.getName() %></td>
    <td><%= player.getAge() %></td>
    <td><%= player.getPosition() %></td>
    <td><%= player.getTeam() %></td>
    <td>
      <a href="editPlayer.jsp?id=<%= player.getId() %>">Edit</a> |
      <a href="PlayerController?action=delete&id=<%= player.getId() %>">Delete</a>
    </td>
  </tr>
  <% } %>
</table>
</body>
</html>
