package Model.prodotto;

import Model.prodotto.Prodotto;
import Model.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdottoExtractor implements ResultSetExtractor<Prodotto> {
    @Override
    public Prodotto extract(ResultSet resultSet) throws SQLException {
        Prodotto prodotto =  new Prodotto();
        prodotto.setNome(resultSet.getString("prodotto.nome"));
        prodotto.setDescrizione(resultSet.getString("prodotto.descrizione"));
        prodotto.setFoto(resultSet.getString("prodotto.foto"));
        prodotto.setIDProdotto(resultSet.getString("prodotto.codice"));
        prodotto.setPrezzo(resultSet.getInt("prodotto.prezzo"));
        prodotto.setQuantita(resultSet.getInt("prodotto.quantita"));
        prodotto.setSconto(resultSet.getInt("prodotto.sconto"));
        return prodotto;


    }
}
