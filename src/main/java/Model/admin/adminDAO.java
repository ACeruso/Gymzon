package Model.admin;

import Model.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class adminDAO {
    public static Admin doLogin(String email,String password) {
        Admin admin = new Admin();
        try {
        Connection con = ConPool.getConnection();
        {
            try {
                PreparedStatement ps = con.prepareStatement("SELECT * FROM Amministratore WHERE email=?,pass=?");
                ps.setString(1, email);
                ps.setString(2,password);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        admin.setEmail(rs.getString(1));
                        admin.setPassword(rs.getString(2));
                        return admin;
                    } else {
                        return null;
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    } catch (SQLException e) {
        throw new RuntimeException("Errore durante il login", e);
    }
}
}
