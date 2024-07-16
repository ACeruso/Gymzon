package Model.utente;

import Model.Manager;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class SqlUtenteDAO extends Manager implements UtenteDAO {

    static final UtenteQuery QUERY = new UtenteQuery("utente");

    public SqlUtenteDAO(DataSource source) {
        super((org.apache.tomcat.jdbc.pool.DataSource) source);
    }

    @Override
    public ArrayList<Utente> doRetriveAll() throws SQLException {
        try (Connection conn = source.getConnection()) {
            String query = "SELECT * FROM cliente";
            try (PreparedStatement ps = conn.prepareStatement(query)) {

                ResultSet set = ps.executeQuery();
                ArrayList<Utente> utenti = new ArrayList<>();
                while (set.next()) {
                    Utente utente = new Utente();
                    utente.setIDCliente(set.getString("id"));
                    utente.setNome(set.getString("nome"));
                    utente.setCognome(set.getString("cognome"));
                    utente.setEmail(set.getString("email"));
                    utenti.add(utente);
                }
                set.close();
                return utenti;
            }

        }
    }


    @Override
    public Optional<Utente> doRetriveUtente(int id) throws SQLException {
        try (Connection conn = source.getConnection()) {

            try (PreparedStatement ps = conn.prepareStatement(QUERY.selectUtenti())) {
                ps.setInt(1, id);
                ResultSet set = ps.executeQuery();
                Utente utente = null;

                if (set.next()) {
                    utente = new UtenteExtractor().extract(set);
                }
                return Optional.ofNullable(utente);
            }
        }

    }

    @Override
    public String createUtente(Utente utente) throws SQLException {
        try (Connection conn = source.getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement(QUERY.insertUtente(), Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(2, utente.getNome());
                ps.setString(3, utente.getCognome());
                ps.setString(4, utente.getEmail());
                ps.setString(5, utente.getPassword());
                ps.setBoolean(6, utente.getAdmin());
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    ResultSet generatedKeys = ps.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        return generatedKeys.getString(1);
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Boolean updateUtente(Utente utente) throws SQLException {
        try (Connection conn = source.getConnection()) {

            try (PreparedStatement ps = conn.prepareStatement(QUERY.updateUtente())) {
                ps.setString(1, utente.getNome());
                ps.setString(2, utente.getCognome());
                ps.setString(3, utente.getEmail());

                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }


    @Override
    public Boolean deleteUtente(String id) throws SQLException {
        try (Connection conn = source.getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement(QUERY.deleteUtente())) {

                ps.setString(1, id);
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    @Override
    public Utente findUtente(String email, String password) throws Exception {
        try (Connection conn = source.getConnection()) {
            String query = "SELECT * FROM cliente WHERE email=? AND password=?";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, email);
                ps.setString(2, password);
                System.out.println(ps.toString());
                ResultSet set = ps.executeQuery();

                Utente utente = null;
                if (set.next()) {
                    System.out.println("Utente trovato");
                    utente = new UtenteExtractor().extract(set);
                }
                return utente;
            }
        }
    }

    @Override
    public int countAll() throws Exception {
        try (Connection conn = source.getConnection()) {
            String query = "SELECT COUNT(*) AS size FROM cliente";
            int size;
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ResultSet set = ps.executeQuery();
                size = 0;
                if (set.next()) {
                    size = set.getInt("size");
                }

            } catch (Exception e) {
                throw e;
            }
            return size;
        }
    }
}