package com.example.playerevaluation.Controller;

import com.example.playerevaluation.DAO.PlayerDAO;
import com.example.playerevaluation.Entity.Player;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class PlayerController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String team = null;
        if ("add".equals(action)) {
            String name = req.getParameter("name");
            int age = Integer.parseInt(req.getParameter("age"));
            String position = req.getParameter("position");
            team = req.getParameter("team");

        } else if ("update".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            int age = Integer.parseInt(req.getParameter("age"));
            String position = req.getParameter("position");

            Player player = new Player();
            player.setName(name);
            player.setAge(age);
            player.setPosition(position);
            player.setId(id);
            player.setTeam(team);

            try {
                PlayerDAO.addPlayer(player);

            } catch (Exception e) {
                e.printStackTrace();
            }
            resp.sendRedirect("/players.jsp");


        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String action = request.getParameter("action");
        if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
        }
        try {
            PlayerDAO playerDAO = new PlayerDAO();
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while deleting the player");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }
        response.sendRedirect("/players.jsp");



    }
}

