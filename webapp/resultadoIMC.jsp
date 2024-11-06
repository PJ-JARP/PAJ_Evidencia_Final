

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Resultado del IMC</title>
</head>
<body>
    <div class="result-container">
        <h1>Resultado del IMC</h1>

        <%
              String imcResult = (String) request.getAttribute("imcResult");
        if (imcResult != null) {
            out.println("<h3>Su IMC es: " + imcResult + "</h3>");
        } else {
            out.println("<h3>No se pudo calcular el IMC.</h3>");
        }
        %>

        <h3>Historial de IMC:</h3>
        <div class="imc-history">
            <%
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().startsWith("IMC_")) {
                            out.println("<p>IMC: " + cookie.getValue() + "</p>");
                        }
                    }
                }
            %>
        </div>

        <a href="calculateIMC.jsp" class="back-link">Calcular de Nuevo</a>
        
           <!-- Mostrar la tabla de pesos como imagen -->
    <h2>Tabla de Pesos</h2>
    <img src="imagen/Obesidad-2-min.jpg"  alt="Tabla de Pesos" class="weight-table">
    </div>
</body>
</html>
