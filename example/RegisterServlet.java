/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String fullName = request.getParameter("fullName");
        int age = Integer.parseInt(request.getParameter("age"));
        
        String gender = request.getParameter("gender");
        double height = Double.parseDouble(request.getParameter("height"));
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User(fullName, age, gender, height, username, password);
        boolean success = UserDatabase.registerUser(user);

        if (success) {
            response.sendRedirect("login.html");
        } else {
            response.getWriter().println("Usuario ya registrado. Intente con otro nombre de usuario.");
        }
    }
}
