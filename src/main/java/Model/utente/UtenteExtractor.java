package Model.utente;

import Model.ResultSetExtractor;
import java.sql.*;

public class UtenteExtractor implements ResultSetExtractor<Utente> {
    @Override
    public Utente extract(ResultSet resultset) throws SQLException {
        Utente utente = new Utente();
        utente.setIDCliente(resultset.getString("id"));
        utente.setNome(resultset.getString("nome"));
        utente.setCognome(resultset.getString("cognome"));
        utente.setEmail(resultset.getString("email"));
        utente.setAdmin(resultset.getBoolean("admin"));
        return utente;
    }

}
