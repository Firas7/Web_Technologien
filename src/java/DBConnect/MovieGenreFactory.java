package DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieGenreFactory {
	public static MovieGenre findById(long movieId, long genreId) {
		MovieGenre mg= new MovieGenre();
		
		Connection conn= DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		String querySQL= "SELECT * FROM movie "
				+ "WHERE movieID=? AND genreID=?";
		
		try {
			pstmt= conn.prepareStatement(querySQL);
			pstmt.setLong(1, movieId);
			pstmt.setLong(2, genreId);
			
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				mg.setMovieId(rs.getLong("movieID"));
				mg.setGenreId(rs.getLong("genreID"));
			}
			return mg;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
