<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<%@ page import="beans.utilisateurs" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Page d'accueil</title>
</head>
<body>
    <h2>
        <%
            // Récupérer l'utilisateur de la session
            utilisateurs utilisateur = (utilisateurs) session.getAttribute("utilisateur");
            if (utilisateur != null) {
                // Afficher les informations de l'utilisateur
                out.print("Bienvenue " + utilisateur.getNom() + " " + utilisateur.getPrenom());
            } else {
                out.print("Utilisateur non trouvé !");
            }
        %>
    </h2>
    <p>Vous êtes connecté.</p>
    <a href="LogoutServlet">Se déconnecter</a>
</body>
</html>
