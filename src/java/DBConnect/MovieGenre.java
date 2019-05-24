package DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MovieGenre {
	private long movieId;
	private long genreId;
	
	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}
	public void setGenreId(long genreId) {
		this.genreId = genreId;
	}
	
	public void insert() {
		Connection conn= DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		
		String insertSQL="INSERT INTO HasGenre VALUES(?, ?)";
		
		try {
			pstmt= conn.prepareStatement(insertSQL);
			pstmt.setLong(1, movieId);
			pstmt.setLong(2, genreId);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Sollte gar nicht moeglich sein!
	public void update() {
		Connection conn= DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		String updateSQL= "UPDATE hasGenre "
				+ "WHERE movieID=? AND genreID=?";
		try {
			pstmt= conn.prepareStatement(updateSQL);
			pstmt.setLong(1, movieId);
			pstmt.setLong(2, genreId);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete() {
		Connection conn= DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		String deleteSQL= "DELETE FROM hasGenre "
				+ "WHERE movieID=? AND genreID=?";
		
		try {
			pstmt= conn.prepareStatement(deleteSQL);
			pstmt.setLong(1, movieId);
			pstmt.setLong(2, genreId);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
