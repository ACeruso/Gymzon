package Controller;

import Model.ordine.*;
import Model.prodotto.*;
import Model.utente.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "AdminController", value = "/AdminController")
public class AdminController extends Controller {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        /*RequestDispatcher dispatcher = request.getRequestDispatcher("Views/crm/controller.jsp");
        dispatcher.forward(request, response);*/
        doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String valore = req.getParameter("valore");
            String indirizzo;
            System.out.println("pre-richiesta utenti");
            UtenteDAO<SQLException> utenteDAO = new SqlUtenteDAO(source);
            SqlOrdineDAO ordineDAO = new SqlOrdineDAO(source);
            ProdottoDAO<SQLException> prodottoDAO = new SqlProdottoDAO(source);

            ArrayList<Ordine> ordini = (ArrayList<Ordine>) ordineDAO.doRetriveAll();
            ArrayList<Utente> utenti = (ArrayList<Utente>) utenteDAO.doRetriveAll();
            ArrayList<Prodotto> prodotti = (ArrayList<Prodotto>) prodottoDAO.doRetriveAll();

            req.setAttribute("utenti", utenti);
            req.setAttribute("ordini", ordini);
            req.setAttribute("prodotti", prodotti);


            if (valore.equalsIgnoreCase("ordini")) {
                indirizzo = "Views/crm/ordini.jsp";
            } else if (valore.equalsIgnoreCase("utenti")){
                indirizzo = "Views/crm/utenti.jsp";
            } else {
                indirizzo = "Views/crm/prodotto.jsp";
            }
            System.out.println(valore);
            System.out.println(utenti.size());
            RequestDispatcher dispatcher = req.getRequestDispatcher(indirizzo);
            dispatcher.forward(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
