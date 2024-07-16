package Model.utente;

import Model.TableQuery;

class UtenteQuery extends TableQuery {

    public UtenteQuery(String table) {
        super(table);
    }

    String selectUtenti(){
        return String.format("SELECT * FROM %s LIMIT", this.table);
    }
    String selectUtentiConIndirizzi(){
        return "SELECT * FROM %s, %s";
        // return String.format("SELECT * FROM %s, %s WHERE  LIMIT ?,?;", this.table);
    }
    String selectUtente(){
        return String.format("SELECT * FROM %s WHERE id=?;", table);
    }
    String insertUtente(){
        return String.format("INSERT INTO %s(nome, cognome, email, password, amministratore) VALUES (?,?,?,?,?);", table);
    }
    String updateUtente(){
        return String.format("UPDATE FROM %s SET nome=?, cognome=? WHERE email=?", table);
    }
    String deleteUtente(){
        return String.format("DELETE FROM %s WHERE id=?", table);
    }
}
