package Model.ordine;

import Model.prodotto.Prodotto;
import Model.utente.Utente;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Ordine {
    private String IDOrdine;
   private String stato;
   private GregorianCalendar data;
   private int nProdotti;
   private String IDUtente;
   private List<Prodotto> listaProdotti;
    public Ordine(){
    listaProdotti=new ArrayList<>();

    }


    public String getIDOrdine() {
        return IDOrdine;
    }

    public void setIDOrdine(String IDOrdine) {
        this.IDOrdine = IDOrdine;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public GregorianCalendar getData() {
        return data;
    }

    public void setData(GregorianCalendar data) {
        this.data = data;
    }

    public int getnProdotti() {
        return nProdotti;
    }

    public void setnProdotti(int nProdotti) {
        this.nProdotti = nProdotti;
    }

    public String getIDUtente() {
        return IDUtente;
    }

    public void setIDUtente(String IDUtente) {
        this.IDUtente = IDUtente;
    }

    public List<Prodotto> getListaProdotti() {
        return listaProdotti;
    }

    public void setListaProdotti(List<Prodotto> listaProdotti) {
        this.listaProdotti = listaProdotti;
    }




}
