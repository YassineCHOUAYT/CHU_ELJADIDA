package controlleur;

import DAO.utilisateursDAO;
import beans.utilisateurs;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/LoginServlet")  // Spécifie l'URL de mapping pour le servlet
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String motDePasse = request.getParameter("motDePasse");

        utilisateurs utilisateur = utilisateursDAO.trouverParEmailEtMotDePasse(email, motDePasse);

        if (utilisateur != null) {
            // L'utilisateur existe, on le redirige vers la page d'accueil
            HttpSession session = request.getSession();
            session.setAttribute("utilisateur", utilisateur);  // Stocker l'utilisateur dans la session
            response.sendRedirect("vues/accueil.jsp");  // Redirige vers la page d'accueil
        } else {
            // L'utilisateur n'existe pas, rediriger vers la page de login avec un message d'erreur
            request.setAttribute("erreur", "Email ou mot de passe incorrect.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("vues/login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
