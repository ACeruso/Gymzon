package Controller;



import Model.utente.Utente;
import Model.utente.utenteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

@WebServlet("submit_registration")
public class RegistrazioneServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confermaPassword = request.getParameter("conferma_password");

        if (!password.equals(confermaPassword)) {
            request.setAttribute("errorMessage", "Le password non coincidono. Riprova.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        Utente nuovoUtente = new Utente();
        nuovoUtente.setNome(nome);
        nuovoUtente.setCognome(cognome);
        nuovoUtente.setEmail(email);
        nuovoUtente.setPassword(password);

        utenteDAO utenteDAO = new utenteDAO();

        try {
            if (utenteDAO.emailEsiste(email)) {
                request.setAttribute("errorMessage", "L'email è già in uso. Scegli un'altra email.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } else {
                utenteDAO.salvaUtente(nuovoUtente);
                request.setAttribute("successMessage", "Registrazione avvenuta con successo. Ora puoi effettuare il login.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Si è verificato un errore durante la registrazione. Riprova.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
