package Model.prodotto;

import Model.Manager;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;


public class SqlProdottoDAO extends Manager implements ProdottoDAO {
    public SqlProdottoDAO(DataSource source) {
        super((org.apache.tomcat.jdbc.pool.DataSource) source);
    }

    @Override
    public ArrayList<Prodotto> doRetriveAll() throws Exception {
        try (Connection conn = source.getConnection()) {
            String query = "SELECT * FROM PRODOTTO PRO";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ResultSet set = ps.executeQuery();
                ProdottoExtractor ext = new ProdottoExtractor();
                ArrayList<Prodotto> prodotti = new ArrayList<>();

                while (set.next()) {
                    prodotti.add(ext.extract(set));
                }
                return prodotti;
            }
        }
    }

    @Override
    public Prodotto doRetriveProdotto(String id) throws Exception {
        try (Connection conn = source.getConnection()) {
            String query = "SELECT * FROM PRODOTTO PRO WHERE IDProdotto=?";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, id);
                ResultSet set = ps.executeQuery();

                Prodotto prodotto = null;

                if (set.next()) {
                    prodotto = new ProdottoExtractor().extract(set);
                }
                return prodotto;
            }
        }

    }

    @Override
    public ArrayList<Prodotto> searchProdotti(String nome) throws Exception {
        try (Connection conn = source.getConnection()) {
            String query = "SELECT * FROM PRODOTTO WHERE nome=?";

            try (PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, nome);
                ResultSet set = ps.executeQuery();

                ArrayList<Prodotto> prodotti = new ArrayList<>();
                ProdottoExtractor ext = new ProdottoExtractor();
                while (set.next()) {
                    prodotti.add(ext.extract(set));
                }
                return prodotti;
            }

        }
    }

    @Override
    public boolean deleteProdotto(String id) throws Exception {
        try (Connection conn = source.getConnection()) {
            String query = "DELETE FROM PRODOTTO WHERE IDProdotto = ?";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, id);
                int value = ps.executeUpdate();

                return value == 1;
            }
        }
    }

    @Override
    public boolean createProdotto(Prodotto prodotto) throws Exception {
        try (Connection conn = source.getConnection()) {
            String query = "INSERT INTO PRODOTTO (IDProdotto,nome, descrizione, prezzo, quantita, sconto, foto) VALUES (?,?,?,?,?,?,?,?)";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, prodotto.getIDProdotto());
                ps.setString(2, prodotto.getNome());
                ps.setString(3, prodotto.getDescrizione());
                ps.setFloat(4, prodotto.getPrezzo());
                ps.setInt(5, prodotto.getQuantita());
                ps.setInt(6, prodotto.getSconto());
                ps.setString(7, prodotto.getFoto());

                int exe = ps.executeUpdate();
                return exe == 1;
            }
        }
    }


    @Override
    public boolean updateProdotto(Prodotto prodotto) throws Exception {
        try (Connection conn = source.getConnection()) {
            String id = prodotto.getIDProdotto();

            String query = "UPDATE PRODOTTO SET nome = ?, descrizione = ?, prezzo = ?, quantita = ?, sconto = ?, foto = ? WHERE IDProdotto = ?";
            try (PreparedStatement ps = conn.prepareStatement(query)) {

                ps.setString(2, prodotto.getNome());
                ps.setString(3, prodotto.getDescrizione());
                ps.setFloat(4, prodotto.getPrezzo());
                ps.setInt(5, prodotto.getQuantita());
                ps.setInt(6,prodotto.getSconto());
                ps.setString(7, prodotto.getFoto());

                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

}
