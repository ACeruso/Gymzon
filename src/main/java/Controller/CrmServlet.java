package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "CrmServlet", value = "/crm/*")
public class CrmServlet extends Controller {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = getPath(request);
        if(path.equals("/dashboard")) {
            try {
                request.getRequestDispatcher(view("crm/dashboard")).forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }

        }
        else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Risorsa non trovata");
        }

    }
}