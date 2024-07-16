package Controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletFooter", value = "/ServletFooter")
public class ServletFooter extends Controller {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String value = request.getParameter("valore");
        String address = "";

        if (value.equalsIgnoreCase("Profilo"))
            address = "Views/crm/profilo.jsp";

        else if (value.equalsIgnoreCase("Pagamenti"))
            address = "Views/cliente/pagamenti.jsp";



        else if (value.equalsIgnoreCase("Storico ordini"))
            address = "Views/cliente/storico_ordini.jsp";
        else
            address = "/index.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        try{
            dispatcher.forward(request, response);
        }catch(Exception e){}

    }


}


