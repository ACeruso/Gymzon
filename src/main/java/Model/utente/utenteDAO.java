package Model.utente;

import Model.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class utenteDAO {
    public Utente doLogin(String email, String password) {
        Utente utente = null;
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Utente WHERE email=? AND password=?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                utente = new Utente();
                utente.setIDCliente(rs.getString("IDCliente"));
                utente.setNome(rs.getString("nome"));
                utente.setCognome(rs.getString("cognome"));
                utente.setEmail(rs.getString("email"));
                utente.setPassword(rs.getString("password"));
                utente.setCellulare(rs.getString("cellulare"));
                utente.setVia(rs.getString("via"));
                utente.setCap(rs.getInt("cap"));
                utente.setPaese(rs.getString("paese"));
                utente.setProvincia(rs.getString("provincia"));
                utente.setAdmin(rs.getBoolean("isAdmin"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return utente;
    }
    public boolean emailEsiste(String email) throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT email FROM Utente WHERE email=?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }
    public void salvaUtente(Utente utente) throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Utente (nome, cognome, email, password) VALUES (?, ?, ?, ?)"
            );
            ps.setString(1, utente.getNome());
            ps.setString(2, utente.getCognome());
            ps.setString(3, utente.getEmail());
            ps.setString(4, utente.getPassword());
            ps.executeUpdate();
        }
    }
}
