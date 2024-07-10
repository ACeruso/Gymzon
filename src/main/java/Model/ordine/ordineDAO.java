package Model.ordine;

import Model.ConPool;
import Model.prodotto.Prodotto;
import Model.utente.Utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ordineDAO {
    public ArrayList<Ordine> doRetriveOrdiniCliente(String IDUtente) {
        ArrayList<Ordine> listaOrdini;
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =con.prepareStatement("SELECT * FROM Ordine WHERE IDCliente=?  ");
            ps.setString(1,IDUtente);

            ResultSet rs = ps.executeQuery();
            listaOrdini = new ArrayList<>();
            while (true) {
                if (!rs.next()) break;
                Ordine ordine = new Ordine();
                ordine.setIDOrdine(rs.getString(1));
                ordine.setStato(rs.getString(2));
                ordine.setData((GregorianCalendar) rs.getObject(3));
                ordine.setnProdotti(rs.getInt(4));
                ordine.setIDUtente(rs.getString(5));
                listaOrdini.add(ordine);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaOrdini;
    }

}
