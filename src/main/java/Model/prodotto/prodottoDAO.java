package Model.prodotto;

import Model.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class prodottoDAO {
    public Prodotto doRetriveProdotto(int idProdotto) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM Prodotto WHERE IDProdotto=?");
            ps.setInt(1, idProdotto);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Prodotto prodotto=new Prodotto();
                prodotto.setIDProdotto(rs.getString(1));
                prodotto.setNome(rs.getString(2));
                prodotto.setDescrizione(rs.getString(3));
                prodotto.setPrezzo(rs.getFloat(4));
                prodotto.setQuantita(rs.getInt(5));
                prodotto.setSconto(rs.getString(6));
                return prodotto;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Prodotto> doRetriveAll() {
        ArrayList<Prodotto> listaProdotti;
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM Prodotto ");
            ResultSet rs = ps.executeQuery();
            listaProdotti = new ArrayList<>();
            while (true) {
                if (!rs.next()) break;
                Prodotto prodotto = new Prodotto();
                prodotto.setIDProdotto(rs.getString(1));
                prodotto.setNome(rs.getString(2));
                prodotto.setDescrizione(rs.getString(3));
                prodotto.setPrezzo(rs.getFloat(4));
                prodotto.setQuantita(rs.getInt(5));
                prodotto.setSconto(rs.getString(6));
                listaProdotti.add(prodotto);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaProdotti;
    }
}
