package Controller;

import Model.prodotto.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ProdottoServlet", value = "/prodotti/*")
@MultipartConfig
public class ProdottoServlet extends Controller {



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            ProdottoDAO<SQLException> prodottoDAO = new SqlProdottoDAO(source);//DATASOURCE
            String value = request.getParameter("valore");

            String nome_prodotto = request.getParameter("nome_prodotto");
            String descrizione = request.getParameter("descrizione");
            int prezzo = Integer.parseInt(request.getParameter("prezzo"));
            int quantita = Integer.parseInt(request.getParameter("quantita"));
            int sconto = Integer.parseInt(request.getParameter("sconto"));


            String message ="";
            Prodotto prodotto = new Prodotto();

            prodotto.setNome(nome_prodotto);
            prodotto.setDescrizione(descrizione);
            prodotto.setPrezzo(prezzo);
            prodotto.setQuantita(quantita);
            prodotto.setSconto(sconto);


            if(value.equalsIgnoreCase("aggiungi"))
            {
                prodottoDAO.createProdotto(prodotto);
                request.setAttribute(message, "Prodotto aggiunto correttamente");
                RequestDispatcher dispatcher = request.getRequestDispatcher("Views/crm/prodotti.jsp");
                dispatcher.forward(request,response);
            }
            else if(value.equalsIgnoreCase("rimuovi"))
            {
                String codice= request.getParameter("codice");
                prodottoDAO.deleteProdotto(codice);
                request.setAttribute(message, "Prodotto rimosso");
                RequestDispatcher dispatcher = request.getRequestDispatcher("Views/crm/prodotti.jsp");
                dispatcher.forward(request,response);
            }
            else if(value.equalsIgnoreCase("modifica"))
            {
                String codice= request.getParameter("codice");
                prodotto.setIDProdotto(codice);
                prodottoDAO.updateProdotto(prodotto);
                request.setAttribute(message, "Prodotto modificato correttamente");
                RequestDispatcher dispatcher = request.getRequestDispatcher("Views/crm/prodotti.jsp");
                dispatcher.forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}