package Controller;

import Model.utente.Utente;
import jakarta.servlet.http.HttpServletRequest;

public class UtenteFormMapper implements FormMapper<Utente> {
    @Override
    public Utente map(HttpServletRequest request, boolean update){
        Utente utente = new Utente();
        utente.setEmail(request.getParameter("email"));
        utente.setNome(request.getParameter("nome"));
        utente.setCognome(request.getParameter("cognome"));
        if(update){
            utente.setIDCliente(request.getParameter("id"));
        }
        return utente;
    }

}
