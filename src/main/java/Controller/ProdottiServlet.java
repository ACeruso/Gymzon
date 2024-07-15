package Controller;

import Model.prodotto.Prodotto;
import Model.prodotto.prodottoDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/products")
public class ProdottiServlet extends HttpServlet {

    private prodottoDAO prodottoDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        prodottoDAO = new prodottoDAO(); // Inizializza il DAO dei prodotti
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Prodotto> prodotti = prodottoDAO.doRetriveAll(); // Recupera tutti i prodotti dal DAO
        request.setAttribute("prodotti", prodotti); // Passa i prodotti alla JSP tramite l'attributo "prodotti"
        request.getRequestDispatcher("/prodotti.jsp").forward(request, response); // Inoltra alla pagina JSP per la visualizzazione
    }
}
