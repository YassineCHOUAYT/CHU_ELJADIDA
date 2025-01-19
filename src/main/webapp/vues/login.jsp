<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
    <h2>Se connecter</h2>
    
    <form action="../LoginServlet" method="post">
        <label for="email">Email :</label>
        <input type="email" name="email" required><br><br>

        <label for="motDePasse">Mot de passe :</label>
        <input type="password" name="motDePasse" required><br><br>

        <input type="submit" value="Se connecter">
    </form>

    <%-- Afficher un message d'erreur si il y en a une --%>
    <%
        String erreur = (String) request.getAttribute("erreur");
        if (erreur != null && !erreur.isEmpty()) {
    %>
        <p style="color:red"><%= erreur %></p>
    <%
        }
    %>
</body>
</html>
