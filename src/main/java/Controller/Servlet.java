package Controller;

import Model.admin.adminDAO;
import Model.prodotto.Prodotto;
import Model.prodotto.prodottoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getProdotto")
public class Servlet     extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // int customerId = Integer.parseInt(request.getParameter("customerId"));
        // instantiating a Model class to query the data
        prodottoDAO service = new prodottoDAO();
        // creating the javabean "customer" to receive the Model response
        // and invocating the Model service by passing the request parameter "customerId"
        Prodotto prodotto = service.doRetriveProdotto(123);
        System.out.println(prodotto);
        //storing the resulting javabean in the "request" object
        // request.setAttribute("customer", customer);
      /*  String address;

        // depending on the Model response the  "address" of the proper View component (jsp) is set
        if (customer == null) {
            request.setAttribute("badId", customerId);
            address = "/WEB-INF/results/unknown-customer.jsp";
        } else if (customer.getBalance() < 0) {
            address = "/WEB-INF/results/negative-balance.jsp";
        } else if (customer.getBalance() < 10000) {
            address = "/WEB-INF/results/normal-balance.jsp";
        } else {
            address = "/WEB-INF/results/high-balance.jsp";
        }

        // The servlet dispatches the control to the chosen jsp (through its address)
        // and passes it both the reference to the javabean (stored in the "request") and
        // the response where the jsp will store the final page.
        RequestDispatcher dispatcher =
                request.getRequestDispatcher(address);
        dispatcher.forward(request, response);


       */
    }
}