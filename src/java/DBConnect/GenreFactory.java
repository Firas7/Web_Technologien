package DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreFactory {
	
	public static Genre findById(long id) {
		Genre g= new Genre();
		
		Connection conn= DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		String querySQL= "SELECT * FROM genre WHERE genreID=?";
		
		try {
			pstmt= conn.prepareStatement(querySQL);
			pstmt.setLong(1, id);
			
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				g.setId(rs.getLong("genreID"));
				g.setGenre(rs.getString("genre"));
			}
			return g;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<Genre> findByGenre(String genre) {
		ArrayList<Genre> list= new ArrayList<Genre>();
		
		Connection conn= DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		String querySQL= "SELECT * FROM genre WHERE genre=?";
		
		try {
			pstmt= conn.prepareStatement(querySQL);
			pstmt.setString(1, genre);
			
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				Genre g= new Genre();
				g.setId(rs.getLong("genreID"));
				g.setGenre(rs.getString("genre"));
				list.add(g);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<Genre> findByAnyGenre(String substr) {
		ArrayList<Genre> list= new ArrayList<Genre>();
		
		Connection conn= DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		String querySQL= "SELECT * FROM genre WHERE UPPER(genre) LIKE UPPER(?)";
		
		// '%?%'
		
		try {
			pstmt= conn.prepareStatement(querySQL);
			pstmt.setString(1, "%" + substr + "%");
			
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				Genre g= new Genre();
				g.setId(rs.getLong("genreID"));
				g.setGenre(rs.getString("genre"));
				list.add(g);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<Genre> findAllGenresInAlphaOrder() {
		ArrayList<Genre> list= new ArrayList<Genre>();
		
		Connection conn= DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		String querySQL= "SELECT * FROM genre ORDER BY genre";
		
		try {
			pstmt= conn.prepareStatement(querySQL);
			
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				Genre g= new Genre();
				g.setId(rs.getLong("genreID"));
				g.setGenre(rs.getString("genre"));
				list.add(g);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<Genre> findByMovie(Movie m) {
		ArrayList<Genre> list= new ArrayList<Genre>();
		
		Connection conn= DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		String querySQL= "SELECT g.genreID, g.genre "
				+ "FROM genre g JOIN hasGenre hg ON (g.genreID = hg.genreID) "
				+ "WHERE hg.MOVIEID=?";
		
		try {
			pstmt= conn.prepareStatement(querySQL);
			pstmt.setLong(1, m.getId());
			
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				Genre g= new Genre();
				g.setId(rs.getLong("genreID"));
				g.setGenre(rs.getString("genre"));
				list.add(g);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
