package Model.prodotto;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.GregorianCalendar;

public class Prodotto {
    private String IDProdotto;
    private String nome;
    private String descrizione;
    private float prezzo;
    private int quantita;
    private int sconto;
    private String foto;


    public Prodotto(){

    }
    public Prodotto(String IDProdotto, String nome, String descrizione, float prezzo, int quantita, int sconto, String foto) {
        this.IDProdotto = IDProdotto;
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.quantita = quantita;
        this.sconto = sconto;
        this.foto = foto;


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

    public int getSconto() {
        return sconto;
    }

    public void setSconto(int sconto) {
        this.sconto = sconto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
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

    public JSONObject toJson() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("IDProdotto", this.IDProdotto);
        json.put("nome", this.nome);
        json.put("prezzo", this.prezzo);
        json.put("descrizione", this.descrizione);
        json.put("foto", this.foto);
        json.put("quantita", this.quantita);
        json.put("sconto", this.sconto);
        return json;
    }
}
