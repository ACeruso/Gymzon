package Model.utente;

public class utenteDAO {

    // Metodo per ottenere il ruolo dell'utente basato sul username
    public String getUserRuolo(String email,String password) {
        String ruolo = null;

       //SELECT ruolo FROM utente WHERE email = ?

        //ruolo = result.getString("ruolo");


        if ("admin".equalsIgnoreCase(email) && "admin".equals(password)) {
            ruolo = "Admin";
        } else {
            ruolo = "Utente";
        }

        return ruolo;
    }
}
