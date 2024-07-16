package Controller;

import java.util.Random;
import Model.ordine.*;
import Model.utente.Utente;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import static Controller.Controller.source;

@WebServlet(name = "PagamentoServlet", value = "/PagamentoServlet")
public class PagamentoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("Views/cliente/pagamento.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer totale = Integer.parseInt(request.getParameter("totale"));
        HttpSession session = request.getSession();

        // Recupera l'oggetto utente dalla sessione
        Utente utente = (Utente) session.getAttribute("utente");
        if(utente == null){
            request.getRequestDispatcher("Views/cliente/ServeLogin.jsp").forward(request, response);
            return;
        }

        Random random = new Random();
        int min = 1;
        int max = 100000000;
        int randomNumber = random.nextInt(max - min + 1) + min;


        Ordine ordine = new Ordine();
        ordine.setIDOrdine(randomNumber);
        ordine.setnProdotti(1);
        ordine.setIDUtente(utente.getIDCliente());

        // Utilizza il DAO per salvare l'ordine nel database
        OrdineDAO ordineDAO = new SqlOrdineDAO(source);
        try {
            boolean success = ordineDAO.createOrdine(ordine);
            if (success) {

                response.sendRedirect("Views/cliente/pagamento.jsp");
            } else {

                response.sendRedirect("/errore_salvataggio.jsp");
            }
        } catch (Exception e) {

            e.printStackTrace();
            response.sendRedirect("/errore_generale.jsp");
        }
    }
}