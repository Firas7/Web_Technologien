package DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Genre {
	private long id;

	private String genre;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void insert() {
		Connection conn= DBConnection.getConnection();
		
		String idSQL= "SELECT seq_GenreID.nextval FROM DUAL";
		
		Statement stmt= null;
		
		try {
			stmt= conn.createStatement();
			ResultSet rs= stmt.executeQuery(idSQL);
			
			while(rs.next()) {
				id= rs.getLong(1);
			}
			
			PreparedStatement pstmt = null;
			
			String insertSQL="INSERT INTO Genre VALUES(?, ?)";
			
			try {
				pstmt= conn.prepareStatement(insertSQL);
				pstmt.setLong(1, id);
				pstmt.setString(2, genre);
				
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void update() {
		Connection conn= DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		String updateSQL= "UPDATE genre SET genre=? "
				+ "WHERE genreID=?";
		try {
			pstmt= conn.prepareStatement(updateSQL);
			pstmt.setString(1, genre);
			pstmt.setLong(2, id);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete() {
		Connection conn= DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		String deleteSQL= "DELETE FROM genre WHERE genreID=?";
		
		try {
			pstmt= conn.prepareStatement(deleteSQL);
			pstmt.setLong(1, id);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
