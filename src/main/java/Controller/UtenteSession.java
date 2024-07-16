package Controller;

import Model.utente.Utente;

public class UtenteSession {
    private final String nome, cognome, ID;
    private final boolean Amministratore;

    public UtenteSession(Utente utente) {
        this.nome = utente.getNome();
        this.cognome = utente.getCognome();
        this.ID = utente.getIDCliente();
        this.Amministratore = utente.getAdmin();
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getID() {
        return ID;
    }

    public boolean Amministratore() {
        return Amministratore;
    }
}
