package Model;

import java.util.GregorianCalendar;

public class Ordine {
    private String IDOrdine;
   private String stato;
   private GregorianCalendar data;
   private int nProdotti;
   private Utente utente;
   private Prodotto prodotto;
    public Ordine(){

    }
    public Ordine(String IDOrdine, String stato, GregorianCalendar data, int nProdotti, Utente utente, Prodotto prodotto) {
        this.IDOrdine = IDOrdine;
        this.stato = stato;
        this.data = data;
        this.nProdotti = nProdotti;
        this.utente = utente;
        this.prodotto = prodotto;
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

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    @Override
    public String toString() {
        return getClass().getName()+": " +
                "IDOrdine='" + IDOrdine + '\'' +
                ", stato='" + stato + '\'' +
                ", data=" + data +
                ", nProdotti=" + nProdotti +
                ", utente=" + utente +
                ", prodotto=" + prodotto;
    }
}
