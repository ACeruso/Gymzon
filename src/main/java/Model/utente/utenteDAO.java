package Model.utente;

import java.sql.SQLException;
import java.util.*;

public interface UtenteDAO <E extends Exception> {

    ArrayList<Utente> doRetriveAll() throws E;

    Optional<Utente> doRetriveUtente(int id) throws E;

    String createUtente(Utente utente) throws E;

    Boolean updateUtente(Utente utente) throws E;

    Boolean deleteUtente(String id) throws E;

    Utente findUtente(String email, String password) throws E;

    int countAll() throws E;

}