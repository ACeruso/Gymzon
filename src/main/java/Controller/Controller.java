package Controller;


import Model.carrello.Carrello;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.json.JSONObject;
import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class Controller extends HttpServlet {
    @Resource(name = "ShoesGate")
    protected static DataSource source;

    protected String getPath(HttpServletRequest req) {return req.getPathInfo() != null ? req.getPathInfo(): "/";}

    protected String view(String viewPath){
        //String basePath = getServletContext().getInitParameter( "basePath");
        String basePath = getServletContext().getContextPath();
        //String engine = getServletContext().getInitParameter("engine");
        return basePath + "/" + viewPath ;
    }

    protected String back(HttpServletRequest request) {return request.getServletPath() + request.getPathInfo();}

    protected  void sendJSON(JSONObject obj, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();

        writer.print(obj.toString());
        writer.flush();
    }


    protected void validate(RequestValidator validator) throws InvalidRequestException {
        if(validator.hasErrors()){
            throw new InvalidRequestException("Validation Error", validator.getErrors(),
                    HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    protected String getUploadPath(){
        return System.getenv("CATALINA HOME") + File.separator + "uploads" + File.separator;
    }

    protected int parsePage(HttpServletRequest request) {return Integer.parseInt(request.getParameter("page"));}

    protected UtenteSession getUtenteSession(HttpSession session) {
        return (UtenteSession) session.getAttribute("utenteSession");
    }
    protected Carrello getSessionCarrello(HttpSession session) {return (Carrello) session.getAttribute("utenteCarrello");}

    protected abstract void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
