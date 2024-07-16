package Controller;

import Model.prodotto.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


@WebServlet(name = "SearchProdotto", value = "/SearchProdotto")
public class SearchProdotto extends Controller{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String nome_prodotto = request.getParameter("nome_prodotto");

            ProdottoDAO<SQLException> prodottoDAO = new SqlProdottoDAO(source);
            ArrayList<Prodotto> prodotti = prodottoDAO.searchProdotti(nome_prodotto);
            JSONObject json = new JSONObject();
            JSONArray array = new JSONArray();

            for(int i=0; i<prodotti.size(); i++)
            {
                array.put(prodotti.get(i).toJson());
            }
            json.put("prodotti", array);
            this.sendJSON(json, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }


}