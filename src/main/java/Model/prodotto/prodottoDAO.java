package Model.prodotto;


import java.util.ArrayList;


public interface ProdottoDAO<E extends Exception>{

    ArrayList<Prodotto> doRetriveAll() throws E;

    Prodotto doRetriveProdotto(String id) throws E;

    ArrayList<Prodotto> searchProdotti(String nome) throws E;

    boolean deleteProdotto(String id) throws E;

    boolean createProdotto(Prodotto prodotto) throws E;

    boolean updateProdotto(Prodotto prodotto) throws E;

}