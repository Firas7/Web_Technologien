package DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieFactory {
	public static Movie findById(long id) {
		Movie m= new Movie();
		
		Connection conn= DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		String querySQL= "SELECT * FROM movie WHERE movieID=?";
		
		try {
			pstmt= conn.prepareStatement(querySQL);
			pstmt.setLong(1, id);
			
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				m.setId(rs.getLong("movieID"));
				m.setTitle(rs.getString("title"));
                                m.setRegisseur(rs.getInt("regisseur"));
				m.setYear(rs.getInt("year"));
				m.setType(rs.getString("type").charAt(0));
			}
			return m;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<Movie> findByTitle(String title) {
		ArrayList<Movie> list= new ArrayList<Movie>();
		
		Connection conn= DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		String querySQL= "SELECT * FROM movie WHERE title=?";
		
		try {
			pstmt= conn.prepareStatement(querySQL);
			pstmt.setString(1, title);
			
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				Movie m= new Movie();
				m.setId(rs.getLong("movieID"));
				m.setTitle(rs.getString("title"));
                                m.setRegisseur(rs.getInt("regisseur"));
				m.setYear(rs.getInt("year"));
				m.setType(rs.getString("type").charAt(0));
				list.add(m);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<Movie> findByAnyTitle(String substr) {
		ArrayList<Movie> list= new ArrayList<Movie>();
		
		Connection conn= DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		String querySQL= "SELECT * FROM movie WHERE UPPER(title) LIKE UPPER(?)";
		
		// '%?%'
		
		try {
			pstmt= conn.prepareStatement(querySQL);
			pstmt.setString(1, "%" + substr + "%");
			
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				Movie m= new Movie();
				m.setId(rs.getLong("movieID"));
				m.setTitle(rs.getString("title"));
                                m.setRegisseur(rs.getInt("regisseur"));
				m.setYear(rs.getInt("year"));
				m.setType(rs.getString("type").charAt(0));
				list.add(m);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
        
	public static List<Movie> findByUser(String username) {
		ArrayList<Movie> list= new ArrayList<>();
		
		Connection conn= DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		String querySQL= "SELECT m.MOVIEID, m.TITLE, m.REGISSEUR, m.YEAR, m.TYPE " +
                                "FROM USERMOVIE um JOIN MOVIE m ON (um.MOVIEID = m.MOVIEID) " +
                                "WHERE um.USERNAME = ?";
		
		try {
			pstmt= conn.prepareStatement(querySQL);
			pstmt.setString(1, username);
			
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				Movie m= new Movie();
				m.setId(rs.getLong("movieID"));
				m.setTitle(rs.getString("title"));
                                m.setRegisseur(rs.getInt("regisseur"));
				m.setYear(rs.getInt("year"));
				m.setType(rs.getString("type").charAt(0));
				list.add(m);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
