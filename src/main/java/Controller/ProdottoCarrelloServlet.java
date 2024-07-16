package Controller;

import Model.carrello.*;
import Model.ordine.*;
import Model.prodotto.*;
import Model.utente.Utente;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ProdottoCarrelloServlet", value = "/ProdottoCarrelloServlet")
public class ProdottoCarrelloServlet extends Controller {
    private final static String CARRELLO = "carrello", MESSAGE = "message", PRODOTTO ="prodotto";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Views/cliente/cart.jsp");
        try {
            dispatcher.forward(request, response);
        }catch(ServletException e) {
            //ignore
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            HttpSession session =request.getSession(true);

            Carrello carrello = (Carrello) session.getAttribute(CARRELLO);

            if(carrello == null) {
                session.setAttribute(CARRELLO, new Carrello());
            }

            String valore = request.getParameter("valore");

            String id = request.getParameter("id");


            ProdottoDAO<SQLException> prodottoDAO = new SqlProdottoDAO(source);
            Prodotto prodotto = prodottoDAO.doRetriveProdotto(id);
            if(valore.equals("rimuovi"))
            {
                assert carrello != null;
                carrello.rimuoviProdotto(id);
                response.sendRedirect("./ProdottoCarrelloServlet");
            }
            else if(valore.equals("aggiungi"))
            {
                int quantita = Integer.parseInt(request.getParameter("quantita"));
                carrello.aggiungiProdotto(new ElementoCarrello(prodotto, quantita).getProdotto());
                response.sendRedirect("/index.jsp");
            }
            else if(valore.equals("completa")) {
                Utente utente = (Utente) (session.getAttribute("utente"));
                OrdineDAO<SQLException> ordineDAO = new SqlOrdineDAO(source);
                Ordine ordine = new Ordine();
                ordine.setCarrello(carrello);
                ordine.setIDUtente(utente.getIDCliente());
                ordineDAO.createOrdine(ordine);

                request.setAttribute(MESSAGE, "Ordine effettuato correttamente");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}