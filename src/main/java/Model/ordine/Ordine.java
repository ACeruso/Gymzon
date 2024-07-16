package Model.ordine;

import Model.carrello.Carrello;
import Model.prodotto.Prodotto;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ordine {
    private String IDOrdine;
    private String stato;
    private LocalDate data;
    private int nProdotti;
    private String IDUtente;
    private List<Prodotto> listaProdotti;
    private Carrello carrello;
    private float total;

    public Ordine(){
        listaProdotti=new ArrayList<>();
    }

    public String getIDOrdine() {
        return IDOrdine;
    }

    public void setIDOrdine(int IDOrdine) {
        this.IDOrdine =""+IDOrdine;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
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

    public void setIDOrdine(String IDOrdine) {
        this.IDOrdine = IDOrdine;
    }

    public Carrello getCarrello() {
        return carrello;
    }

    public void setCarrello(Carrello carrello) {
        this.carrello = carrello;
    }

    public float getTotal() {
        for (Prodotto prodotto : listaProdotti) {
            total += prodotto.getPrezzo();
        }
        return total;
    }
}
