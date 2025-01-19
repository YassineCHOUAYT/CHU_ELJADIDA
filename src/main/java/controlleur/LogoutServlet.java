package controlleur;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();  // Invalider la session
        response.sendRedirect("vues/login.jsp");  // Redirige vers la page de login
    }
}
