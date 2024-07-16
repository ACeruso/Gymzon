package Model.ordine;

import Model.Manager;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class SqlOrdineDAO extends Manager implements OrdineDAO {

    public SqlOrdineDAO(DataSource source) {
        super((org.apache.tomcat.jdbc.pool.DataSource) source);
    }

    @Override
    public ArrayList<Ordine> doRetriveAll() throws Exception {
        try (Connection conn = source.getConnection()) {
            String query = "SELECT * FROM ORDINE";
            try (PreparedStatement ps = conn.prepareStatement(query)) {

                ResultSet rs = ps.executeQuery();
                ArrayList<Ordine> ordini = new ArrayList<>();
                while (rs.next()) {
                    Ordine ordine = new Ordine();
                    ordine.setIDOrdine(Integer.parseInt(rs.getString(1)));
                    ordine.setStato(rs.getString(2));
                    ordine.setData(rs.getDate(3).toLocalDate());
                    ordine.setnProdotti(rs.getInt(4));
                    ordine.setIDUtente(rs.getString(5));
                    ordini.add(ordine);
                }
                rs.close();
                return ordini;
            }
        }
    }

    public ArrayList<Ordine> doRetriveOrdiniCliente(String IDUtente) throws Exception {
        ArrayList<Ordine> listaOrdini;
        try (Connection conn = source.getConnection()) {
            PreparedStatement ps =conn.prepareStatement("SELECT * FROM Ordine WHERE IDCliente=?  ");
            ps.setString(1,IDUtente);

            ResultSet rs = ps.executeQuery();
            listaOrdini = new ArrayList<>();
            while (true) {
                if (!rs.next()) break;
                Ordine ordine = new Ordine();
                ordine.setIDOrdine(Integer.parseInt(rs.getString(1)));
                ordine.setStato(rs.getString(2));
                ordine.setData(rs.getDate(3).toLocalDate());
                ordine.setnProdotti(rs.getInt(4));
                ordine.setIDUtente(rs.getString(5));
                listaOrdini.add(ordine);

            }

        }
        return listaOrdini;
    }


    @Override
    public boolean createOrdine(Ordine ordine) throws Exception {
        try (Connection conn = source.getConnection()) {
            String query = "INSERT INTO ORDINE (IDOrdine,stato,data, nProdotti, IDCliente) VALUES (?,?,?,?)";

            try (PreparedStatement ps = conn.prepareStatement(query)){
                ps.setString(1, ordine.getIDOrdine());
                ps.setString(2, ordine.getStato());
                ps.setDate(3, Date.valueOf(ordine.getData()));
                ps.setInt(4, ordine.getnProdotti());
                ps.setString(5, ordine.getIDUtente());
                ps.setFloat(7, ordine.getTotal());


                int exe = ps.executeUpdate();
                return exe == 1;

            }

        }
    }
}