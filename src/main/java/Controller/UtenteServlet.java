package Controller;

import Model.utente.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@WebServlet(name = "UtenteServlet", value = "/UtenteServlet/*")
public class UtenteServlet extends Controller {
    private UtenteDAO<SQLException> utenteDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        utenteDAO = new SqlUtenteDAO(source);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = getPath(request);
        if (path == null) {
            path = "/";
        }
        System.out.println(path);
        String valore = request.getParameter("valore");
        String indirizzo = "";
        if (valore.equalsIgnoreCase("login")) {
            //Una volta fatto il dispatch e il forward la pagina deve completare l'esecuzione.
            try {
                request.getRequestDispatcher(("/Views/cliente/login.jsp")).forward(request, response);
                return;
            }catch(ServletException e) {}

        } else if (valore.equalsIgnoreCase("modifica")) {
            try{
                request.getRequestDispatcher("/Views/crm/updateprofilo.jsp").forward(request, response);
                return;
            }catch(ServletException e) {}
        }



        if (valore.equalsIgnoreCase("logout")) {
            HttpSession session = request.getSession(false);
            Utente utente = (Utente) session.getAttribute("utente");
            String message = "";
            if (utente != null) {
                session.setAttribute("utente", null);
                session.invalidate();
                request.setAttribute(message, "Logout effettuato con successo");
            } else {
                request.setAttribute(message, "Devi prima effettuare il login");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            try{
                dispatcher.forward(request, response);
            }catch(ServletException e) {}

        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Path non trovato");
        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = getPath(request);
        String valore = request.getParameter("valore");
        if (valore.equalsIgnoreCase("createUpdate")) {
            try {
                String nome = request.getParameter("nome");
                String cognome = request.getParameter("cognome");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String conferma_pass = request.getParameter("conferma_pass");
                String via_e_numero = request.getParameter("via e numero");
                String citta = request.getParameter("citta");
                String provincia = request.getParameter("provincia");
                String registrazione = request.getParameter("registrazione");
                int CAP = Integer.parseInt(request.getParameter("cap"));

                Utente utente = new Utente();
                utente.setNome(nome);
                utente.setCognome(cognome);
                utente.setEmail(email);
                utente.setPassword(password);
                utente.setPaese(citta);
                utente.setCap(CAP);
                utente.setProvincia(provincia);
                utente.setVia(via_e_numero);
                String indirizzo = "";
                String message = "";

                UtenteDAO<SQLException> utenteDAO = new SqlUtenteDAO(source);


                if (registrazione.equalsIgnoreCase("true")) {
                    if (!conferma_pass.equals(password)) {
                        request.setAttribute(message, "Password errate.");
                        indirizzo = "/Views/cliente/login.jsp";
                        request.getRequestDispatcher(indirizzo).forward(request, response);
                        return;
                    }
                    String id = utenteDAO.createUtente(utente);
                    if (id != null) {
                        utente.setIDCliente(id);
                        utente.setPaese(citta);
                        utente.setCap(CAP);
                        utente.setProvincia(provincia);
                        utente.setVia(via_e_numero);

                        HttpSession session = request.getSession();
                        session.setAttribute("utente", utente);
                        request.setAttribute(message, "Creazione dell'account avvenuta correttamente");
                    } else {
                        request.setAttribute(message, "Errore nella creazione dell'account");
                    }
                    indirizzo = "/index.jsp";
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher(indirizzo);
                dispatcher.forward(request, response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


        if (valore.equalsIgnoreCase("modifica")) {
            try {
                HttpSession session = request.getSession();
                Utente utente = (Utente) session.getAttribute("utente");
                String message = "";

                String nome = request.getParameter("nome");
                String cognome = request.getParameter("cognome");
                String email = request.getParameter("email");

                utente.setNome(nome);
                utente.setCognome(cognome);
                utente.setEmail(email);

                UtenteDAO<SQLException> utenteDAO = new SqlUtenteDAO(source);
                utenteDAO.updateUtente(utente);

                // Aggiorna l'oggetto Utente nella sessione
                session.setAttribute("utente", utente);

                // Imposta un messaggio di successo per l'utente
                request.setAttribute("message", "Profilo utente aggiornato correttamente");

                // Ridireziona l'utente alla pagina di modifica profilo o ad altra pagina di successo
                RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                // Potresti gestire qui eventuali errori nel database o nel salvataggio dei dati
            } catch (NumberFormatException e) {
                // Gestisci l'eccezione se il CAP non è un numero valido
                e.printStackTrace();
            }
        }  // Gestisci altre operazioni se necessario
        //response.sendError(HttpServletResponse.SC_NOT_FOUND, "Path non trovato");


        if(valore.equalsIgnoreCase("signin"))

        {
            try {
                String email = request.getParameter("email");
                String password = request.getParameter("password");

                UtenteDAO<SQLException> utenteDAO = new SqlUtenteDAO(source);

                // MessageDigest digest = MessageDigest.getInstance("SHA-512");
                //byte[] hashedPwd = digest.digest(password.getBytes(StandardCharsets.UTF_8));
                //password = Base64.getEncoder().encodeToString(hashedPwd);
                System.out.println("cerco utente");
                Utente utente = utenteDAO.findUtente(email, password);
                System.out.println("utente-trovato" + utente.getAdmin());
                {
                    HttpSession session = request.getSession();
                    session.setAttribute("utente", utente);

                    RequestDispatcher dispatcher;
                    if (utente.getAdmin()) {
                        dispatcher = request.getRequestDispatcher("/Views/crm/controller.jsp");
                    } else {
                        dispatcher = request.getRequestDispatcher("/index.jsp");
                    }
                    dispatcher.forward(request, response);

                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}