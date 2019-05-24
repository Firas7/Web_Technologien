package DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Benutzer {
    private String userName;
    private String passwort;
    
    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the passwort
     */
    public String getPasswort() {
        return passwort;
    }

    /**
     * @param passwort the passwort to set
     */
    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }
    
    public void insert() {
        try {
            Connection conn = DBConnection.getConnection();

            PreparedStatement pstmt = null;

            //INSERT INTO Movie VALUES(MovieID, Title, Year, Type);
            String insertSQL ="INSERT INTO Benutzer VALUES(?, ?)";

            pstmt= conn.prepareStatement(insertSQL);
            pstmt.setString(1, getUserName());
            pstmt.setString(2, getPasswort());

            pstmt.executeUpdate();
        }   
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public String toString() {
        return getUserName() + " " + getPasswort();
    }
}
