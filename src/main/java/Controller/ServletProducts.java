package Controller;

import Model.prodotto.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletProducts", value = "/ServletProducts")
public class ServletProducts extends Controller {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            ProdottoDAO<SQLException> productDAO = new SqlProdottoDAO(source);
            List<Prodotto> prodotti = productDAO.doRetriveAll();

            JSONObject object = new JSONObject();
            JSONArray array = new JSONArray();

            for(int i=0; i<prodotti.size(); i++)
                array.put(prodotti.get(i).toJson());

            object.put("prodotti", array);
            this.sendJSON(object, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

}



