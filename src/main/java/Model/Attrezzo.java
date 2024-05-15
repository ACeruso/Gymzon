package Model;

public class Attrezzo extends Prodotto {
    private String tipo;

    public Attrezzo(String tipo) {
        this.tipo = tipo;
    }

    public Attrezzo(String IDProdotto, String nome, String descrizione, float prezzo, int quantita, String sconto, String tipo) {
        super(IDProdotto, nome, descrizione, prezzo, quantita, sconto);
        this.tipo = tipo;
    }

    @Override
    public String getIDProdotto() {
        return super.getIDProdotto();
    }

    @Override
    public void setIDProdotto(String IDProdotto) {
        super.setIDProdotto(IDProdotto);
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    @Override
    public String getDescrizione() {
        return super.getDescrizione();
    }

    @Override
    public void setDescrizione(String descrizione) {
        super.setDescrizione(descrizione);
    }

    @Override
    public float getPrezzo() {
        return super.getPrezzo();
    }

    @Override
    public void setPrezzo(float prezzo) {
        super.setPrezzo(prezzo);
    }

    @Override
    public int getQuantita() {
        return super.getQuantita();
    }

    @Override
    public void setQuantita(int quantita) {
        super.setQuantita(quantita);
    }

    @Override
    public String getSconto() {
        return super.getSconto();
    }

    @Override
    public void setSconto(String sconto) {
        super.setSconto(sconto);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() +
                " tipo='" + tipo;
    }
}
