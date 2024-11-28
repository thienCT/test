package com.example.playerevaluation.DAO;

import com.example.playerevaluation.Entity.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/player_evaluation;";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    public static void addPlayer(Player player) throws SQLException {
        String query = "INSERT INTO players (name, age, position, team) VALUES (?, ?,?,?)";
        try (Connection connection = getConnection();
            PreparedStatement ps = getConnection().prepareStatement(query)){
            ps.setString(1, player.getName());
            ps.setInt(2, player.getAge());
            ps.setString(3, player.getPosition());
            ps.setString(4,player.getTeam());
            ps.executeUpdate();
        }

    }
    //get all player
    public static List<Player> getAllPlayers() throws SQLException {
        List<Player> players = new ArrayList<>();
        String query = "SELECT * FROM players";
        try (Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query)){
            while (rs.next()) {
                Player player = new Player();
                player.setId(rs.getInt("id"));
                player.setName(rs.getString("name"));
                player.setAge(rs.getInt("age"));
                player.setPosition(rs.getString("position"));
                player.setTeam(rs.getString("team"));
                players.add(player);

            }
            return players;
        }
    }
    //get player by id
    public static Player getPlayerById(int id) throws SQLException {
        Player player = null;
        String query = "SELECT * FROM players WHERE id = ?";
        try (Connection connection = getConnection();
        PreparedStatement ps = getConnection().prepareStatement(query)){
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    ;
                    player.setId(rs.getInt("id"));
                    player.setName(rs.getString("name"));
                    player.setAge(rs.getInt("age"));
                    player.setPosition(rs.getString("position"));
                    player.setTeam(rs.getString("team"));

                }
            }
        }
        return player;
    }
    //update player
    public static void updatePlayer(Player player) throws SQLException {
        String query = "Update players Set name = ?, age = ?, position = ?, team = ? WHERE id = ?";
        try {
            Connection connection = getConnection();
            PreparedStatement ps = getConnection().prepareStatement(query);
            ps.setString(1, player.getName());
            ps.setInt(2, player.getAge());
            ps.setString(3, player.getPosition());
            ps.setString(4, player.getTeam());
            ps.setInt(5, player.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

