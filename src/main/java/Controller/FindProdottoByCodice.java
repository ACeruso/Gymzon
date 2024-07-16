package Controller;

import Model.prodotto.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "FindProdottoByCodice", value = "/FindProdottoByCodice")
public class FindProdottoByCodice extends Controller {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try{
            String id= request.getParameter("id");

            ProdottoDAO<SQLException> prodottoDAO = new SqlProdottoDAO(source);
            Prodotto prodotto = prodottoDAO.doRetriveProdotto(id);

            request.setAttribute("prodotto", prodotto);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Views/prodotto.jsp");
            dispatcher.forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

}