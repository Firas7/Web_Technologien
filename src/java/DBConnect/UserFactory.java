package DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserFactory {
    /**
     * find-Methode zum Finden eines Benutzers aus der Datenbank.
     * @param userName
     * @return Benutzer-Objekt, wenn vorhanden. Null, wenn nicht vorhanden.
     */
    public static Benutzer findByUserName(String userName) {
        Benutzer b = null;
        
        String querySQL = "SELECT * FROM benutzer WHERE UserName = ?";

        try {
            Connection conn = DBConnection.getConnection();

            PreparedStatement pstmt = conn.prepareStatement(querySQL);
            pstmt.setString(1, userName);

            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                b = new Benutzer();
                b.setUserName(userName);
                b.setPasswort(rs.getString("passwort"));
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return b;
    }
}
