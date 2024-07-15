<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.utente.Utente" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard - Gymzon</title>
    <link rel="stylesheet" type="text/css" href="admin.css">
</head>
<body>
<%
    Utente utente = (Utente) session.getAttribute("utente");
    if (utente == null || !utente.isAdmin()) {
        response.sendRedirect("home.jsp");
        return;
    }
%>
<div class="container">
    <header>
        <h1>Benvenuto, Admin</h1>
        <nav>
            <a href="home.jsp">Home</a>
            <a href="logout.jsp">Logout</a>
        </nav>
    </header>
    <section>
        <h2>Gestione Prodotti</h2>
        <ul>
            <li><a href="aggiungiProdotto.jsp">Aggiungi Prodotto</a></li>
            <li><a href="modificaProdotto.jsp">Modifica Prodotto</a></li>
            <li><a href="rimuoviProdotto.jsp">Rimuovi Prodotto</a></li>
        </ul>
    </section>
    <section>
        <h2>Gestione Alimenti</h2>
        <ul>
            <li><a href="modificaQuantitaAlimento.jsp">Modifica Quantità Alimento</a></li>
        </ul>
    </section>
</div>
</body>
</html>
