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
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = UserDatabase.authenticate(username, password);

        //verificación de usuario
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user); // Guarda el objeto user completo en la sesión
            response.sendRedirect("calculateIMC.jsp");
        } else {
            response.getWriter().println("Usuario o contraseña incorrectos.");
        }
          
    }
}
