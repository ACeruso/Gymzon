<% Utente utente = null; %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.utente.Utente" %>
<%@ page import="Model.prodotto.Prodotto" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Benvenuto <%=utente.getNome()%> </title>
    <link rel="stylesheet" type="text/css" href="user.css">
</head>
<body>
    <%
        utente = (Utente) session.getAttribute("utente");
        if (utente == null || utente.isAdmin()) {
            response.sendRedirect("home.jsp");
            return;
        }
    %>
<div class="container">
    <header>

        <nav>
            <a href="home.jsp">Home</a>
            <a href="logout.jsp">Logout</a>
        </nav>
    </header>



</div>
</body>
</html>