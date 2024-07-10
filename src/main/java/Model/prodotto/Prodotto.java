package Model.prodotto;

import java.util.GregorianCalendar;

public class Prodotto {
    private String IDProdotto;
    private String nome;
    private String descrizione;
    private float prezzo;
    private int quantita;
    private String sconto;


    public Prodotto(){

    }
    public Prodotto(String IDProdotto, String nome, String descrizione, float prezzo, int quantita, String sconto) {
        this.IDProdotto = IDProdotto;
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.quantita = quantita;
        this.sconto = sconto;



    }

    public String getIDProdotto() {
        return IDProdotto;
    }

    public void setIDProdotto(String IDProdotto) {
        this.IDProdotto = IDProdotto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public String getSconto() {
        return sconto;
    }

    public void setSconto(String sconto) {
        this.sconto = sconto;
    }


    @Override
    public String toString() {
        return "Prodotto{" +
                "IDProdotto='" + IDProdotto + '\'' +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", prezzo=" + prezzo +
                ", quantita=" + quantita +
                ", sconto='" + sconto + '\'' +
                '}';
    }
}
