package Model;

public class Utente {
    private String IDCliente;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private String cellulare;
    private String via;
    private int cap;
    private String paese;
    private String provincia;

    public Utente() {
    }
    public Utente(String IDCliente, String nome, String cognome, String email, String password, String cellulare, String via, int cap, String paese, String provincia) {
        this.IDCliente = IDCliente;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.cellulare = cellulare;
        this.via = via;
        this.cap = cap;
        this.paese = paese;
        this.provincia = provincia;
    }


    public String getIDCliente() {
        return IDCliente;
    }

    public void setIDCliente(String IDCliente) {
        this.IDCliente = IDCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCellulare() {
        return cellulare;
    }

    public void setCellulare(String cellulare) {
        this.cellulare = cellulare;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public String getPaese() {
        return paese;
    }

    public void setPaese(String paese) {
        this.paese = paese;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return getClass().getName()+": " +
                "IDCliente='" + IDCliente + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", cellulare='" + cellulare + '\'' +
                ", via='" + via + '\'' +
                ", cap=" + cap +
                ", paese='" + paese + '\'' +
                ", provincia='" + provincia + '\'';
    }
}
