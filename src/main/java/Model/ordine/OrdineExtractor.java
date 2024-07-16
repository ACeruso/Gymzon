package Model.ordine;

import Model.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdineExtractor implements ResultSetExtractor<Ordine> {
    @Override
    public Ordine extract(ResultSet resultSet) throws SQLException {
        Ordine ordine = new Ordine();
        ordine.setIDOrdine(resultSet.getInt("ord.id"));
        ordine.setnProdotti(resultSet.getInt("ord.quantita"));
        ordine.setData(resultSet.getDate("ord.date").toLocalDate());
        ordine.setIDUtente(resultSet.getString("ord.utente_id"));
        return ordine;
    }
}