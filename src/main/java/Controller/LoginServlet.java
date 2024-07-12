package Controller;

import Model.admin.Admin;
import Model.admin.adminDAO;
import Model.utente.Utente;
import Model.utente.utenteDAO;
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
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();

        // Controlla se l'email appartiene all'admin
        if ("admin@esempio.com".equals(email)) {
            adminDAO adminDAO = new adminDAO();
            Admin admin = adminDAO.doLogin(email, password);

            if (admin != null) {
                session.setAttribute("admin", admin);
                response.sendRedirect("admin.jsp");
            } else {
                request.setAttribute("errorMessage", "Email o password errati. Riprova.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            utenteDAO utenteDAO = new utenteDAO();
            Utente utente = utenteDAO.doLogin(email, password);

            if (utente != null) {
                session.setAttribute("utente", utente);
                response.sendRedirect("user.jsp");
            } else {
                request.setAttribute("errorMessage", "Email o password errati. Riprova.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }
}
