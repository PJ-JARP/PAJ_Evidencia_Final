

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.example.User" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="es">
<head>
    
    <meta charset="UTF-8">
    <title>Calcular IMC</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    
</head>
<body>
    <div class="header">
        <%
            // Obtener el usuario de la sesión
            User user = (User) session.getAttribute("user");
            if (user != null) {
                out.println("<h2>Bienvenido, " + user.getFullName() + "!</h2>");
            } else {
                out.println("<h2>Debe iniciar sesión para calcular su IMC.</h2>");
                return;
            }
        %>
      
   <h1>Calcular IMC</h1>
    <form action="calculateIMC" method="post">
        <label for="peso">Peso (Kg):</label>
        <input type="number" id="weight" name="weight" required><br><br>

        <label for="estatura">Estatura (m):</label>
        <input type="number" step="0.01" id="height" name="height" required><br><br>

        <label for="edad">Edad:</label>
        <input type="number" id="age" name="age" required><br><br>

        <input type="submit" value="Calcular IMC">
    </form>
   
     <!-- Mostrar la tabla de pesos como imagen -->
    <h2>Tabla de Pesos</h2>
    <img src="imagen/Obesidad-2-min.jpg"  alt="Tabla de Pesos" class="weight-table">

 
    <!-- boton para regresar al inicio -->
    <a href="index.html" class="back-button">Volver a Inicio</a>
    
    </div>

</body>
</html>