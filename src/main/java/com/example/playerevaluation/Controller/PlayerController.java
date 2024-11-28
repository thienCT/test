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
        if ("add".equals(action)) {
            String name = req.getParameter("name");
            String position = req.getParameter("position");
            String team = req.getParameter("team");
            String ageStr = req.getParameter("age");

            StringBuilder errors = new StringBuilder();
            if (name == null || name.trim() .isEmpty()) {
                errors.append("Name cannot be empty\n");
            }
            if (position == null || position.trim().isEmpty()) {
                errors.append("Position cannot be empty\n");
            }
            if (team == null || team.trim().isEmpty()) {
                errors.append("Team cannot be empty\n");
            }
            int age = 0;
            try{
                if (ageStr == null || ageStr.trim().isEmpty()) {
                    age = Integer.parseInt(ageStr);
                    if (age <= 0) {
                        errors.append("Age must be a postive number\n");

                    }else {
                        errors.append("Age is required\n");
                    }
                }
            }
            catch (NumberFormatException e){
                errors.append("Age must be a valid number\n");
            }
            if (errors.length() > 0) {
                req.setAttribute("errors", errors.toString());
                req.getRequestDispatcher("error.jsp").forward(req, resp);
                return;
            }

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
            player.setTeam(player.getTeam());

            try {
                PlayerDAO.addPlayer(player);

            } catch (Exception e) {
                e.printStackTrace();
            }
            resp.sendRedirect("/players.jsp");


        }

    }
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        String team = req.getParameter("team");
        String name = req.getParameter("name");
        String position = req.getParameter("position");
        String ageStr = req.getParameter("age");

        StringBuilder errors = new StringBuilder();
        if (idStr == null || idStr.trim().isEmpty()) {
            errors.append("ID cannot be empty\n");
        }
        if (name == null || name.trim().isEmpty()) {
            errors.append("Name is required\n");
        }
        if (team == null || team.trim().isEmpty()) {
            errors.append("Team is required\n");
        }
        int age = 0;
        try {
            if (ageStr == null || ageStr.trim().isEmpty()) {
                age = Integer.parseInt(ageStr);
                if (age <= 0) {
                    errors.append("Age must be a postive number\n");
                }
                else {
                    errors.append("Age is required\n");
                }
            }
        }catch (NumberFormatException e){
            errors.append("Age must be a valid number\n");
        }
        if (errors.length() > 0) {
            req.setAttribute("errors", errors.toString());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
            return;
        }
        Player player = new Player();
        player.setId(Integer.parseInt(idStr));
        player.setName(name);
        player.setAge(age);
        player.setPosition(position);
        player.setTeam(team);

        try {
            PlayerDAO.updatePlayer(player);

        }catch (Exception e){
            e.printStackTrace();
            req.setAttribute("errors", errors.toString());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
            return;
        }
        resp.sendRedirect("/players.jsp");

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

