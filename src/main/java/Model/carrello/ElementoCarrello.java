package Model.carrello;

import Model.prodotto.Prodotto;

public class ElementoCarrello {
    private final Prodotto prodotto;
    private final int quantita;


    public ElementoCarrello(Prodotto prodotto, int quantita) {
        this.prodotto = prodotto;
        this.quantita = quantita;
    }

    public Prodotto getProdotto(){
        return prodotto;
    }

    public int getQuantita(){
        return quantita;
    }

    public float total(){
        return prodotto.getPrezzo() * quantita;
    }
}
