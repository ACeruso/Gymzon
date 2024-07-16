package Model.ordine;

import java.util.ArrayList;

public interface OrdineDAO<E extends Exception>{

    ArrayList<Ordine> doRetriveAll() throws E;

    ArrayList<Ordine> doRetriveOrdiniCliente(String utente_id) throws E;


    boolean createOrdine(Ordine ordine) throws E;

    /**/

}
