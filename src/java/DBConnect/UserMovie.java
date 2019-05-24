package DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserMovie {
	
	private String userName;
        private long movieID;

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setMovieID(long movieID) {
		this.movieID = movieID;
	}

	public long getPasswort() {
		return movieID;
	}
	
	public void insert() {
		try {
                    Connection conn= DBConnection.getConnection();
			
                    PreparedStatement pstmt = null;

                    //INSERT INTO Movie VALUES(MovieID, Title, Year, Type);
                    String insertSQL="INSERT INTO UserMovie VALUES(?, ?)";

                            pstmt= conn.prepareStatement(insertSQL);
                            pstmt.setString(1, userName);
                            pstmt.setLong(2, movieID);

                            pstmt.executeUpdate();
                }	
                catch (SQLException e) {
                        e.printStackTrace();
                }
            }
	
        //lösche Film aus Persöhnlicher Bibliothek des Benutzers
	public void delete() {
		
		PreparedStatement pstmt = null;
		String deleteSQL= "DELETE FROM usermovie WHERE movieID=?";
		
		try {
                    Connection conn= DBConnection.getConnection();
		
                    pstmt= conn.prepareStatement(deleteSQL);
                    pstmt.setLong(1, movieID);
		
		pstmt.executeUpdate();
			
            } catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return userName;
	}
}
