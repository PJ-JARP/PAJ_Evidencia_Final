/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

@WebServlet("/calculateIMC")
public class IMCCalculatorServlet extends HttpServlet {
    @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            out.println("Debe iniciar sesión para calcular su IMC.");
            return;
        }
        
        User user = (User) session.getAttribute("user");
        
         // Aquí se muestra el nombre completo del usuario
        out.println("<h3>Bienvenido, " + user.getFullName() + "!</h3>");
            
         // Recuperar los valores del formulario
        double weight = Double.parseDouble(request.getParameter("weight"));
        double height = Double.parseDouble(request.getParameter("height"));
        int age = Integer.parseInt(request.getParameter("age"));
           
         // Validación de los valores
        if (weight <= 0 || height < 1 || height > 2.5 || age < 15) {
            out.println("Valores de peso, estatura o edad no válidos.");
            return;
        }
        
         // Calcular el IMC
        double imc = weight / (height * height);
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedIMC = df.format(imc);

        // Guardar el IMC en una cookie
        Cookie imcCookie = new Cookie("IMC_" + System.currentTimeMillis(), formattedIMC);
        response.addCookie(imcCookie);
             
        // Guardar el resultado de IMC como atributo
        request.setAttribute("imcResult", formattedIMC);
        request.getRequestDispatcher("resultadoIMC.jsp").forward(request, response);
        
    }
}
