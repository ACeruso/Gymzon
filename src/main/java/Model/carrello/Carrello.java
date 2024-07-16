package Model.carrello;

import Model.prodotto.Prodotto;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

public class Carrello {
    private String idCarrello;
    private float totale;
    private List<Prodotto> listaProdotti;



    public Carrello() {
            listaProdotti = new ArrayList<>();
        }

    public List<Prodotto> getProdotti() {
            return listaProdotti;
        }

    public void aggiungiProdotto(Prodotto prodotto) {
            listaProdotti.add(prodotto);
        }

    public double calcolaTotale() {
        double totale = 0.0;
        for (Prodotto prodotto : listaProdotti) {
            totale += prodotto.getPrezzo();
        }
        return totale;
    }

    public void rimuoviProdotto(String IDprodotto) {
        for (Prodotto prodotto : listaProdotti) {
            if (prodotto.getIDProdotto().equals(IDprodotto)) {
                listaProdotti.remove(prodotto);
                return;
            }
        }
    }

    public void svuotaCarrello() {
        listaProdotti.clear();
    }

    public int numeroProdotti() {
        return listaProdotti.size();
    }

}