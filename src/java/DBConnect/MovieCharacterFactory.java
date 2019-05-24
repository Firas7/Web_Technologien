package DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieCharacterFactory {
	public static MovieCharacter findById(long id) {
		MovieCharacter mc= new MovieCharacter();
		
		Connection conn= DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		String querySQL= "SELECT * FROM movieCharacter WHERE movCharID=?";
		
		try {
			pstmt= conn.prepareStatement(querySQL);
			pstmt.setLong(1, id);
			
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				mc.setId(rs.getLong("movCharID"));
				mc.setCharacter(rs.getString("character"));
				mc.setAlias(rs.getString("alias"));
				mc.setPos(rs.getInt("position"));
				mc.setPlayerId(rs.getLong("personID"));
				mc.setMovieId(rs.getLong("movieID"));
			}
			return mc;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<MovieCharacter> findByCharacter(String character) {
		ArrayList<MovieCharacter> list= new ArrayList<MovieCharacter>();
		
		Connection conn= DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		String querySQL= "SELECT * FROM movieCharacter WHERE character=?";
		
		try {
			pstmt= conn.prepareStatement(querySQL);
			pstmt.setString(1, character);
			
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				MovieCharacter mc= new MovieCharacter();
				mc.setId(rs.getLong("movCharID"));
				mc.setCharacter(rs.getString("character"));
				mc.setAlias(rs.getString("alias"));
				mc.setPos(rs.getInt("position"));
				mc.setPlayerId(rs.getLong("personID"));
				mc.setMovieId(rs.getLong("movieID"));
				list.add(mc);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<MovieCharacter> findByAnyCharacter(String substr) {
		ArrayList<MovieCharacter> list= new ArrayList<MovieCharacter>();
		
		Connection conn= DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		String querySQL= "SELECT * FROM movieCharacter WHERE UPPER(character) LIKE UPPER(?)";
		
		// '%?%'
		
		try {
			pstmt= conn.prepareStatement(querySQL);
			pstmt.setString(1, "%" + substr + "%");
			
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				MovieCharacter mc= new MovieCharacter();
				mc.setId(rs.getLong("movCharID"));
				mc.setCharacter(rs.getString("character"));
				mc.setAlias(rs.getString("alias"));
				mc.setPos(rs.getInt("position"));
				mc.setPlayerId(rs.getLong("personID"));
				mc.setMovieId(rs.getLong("movieID"));
				list.add(mc);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<MovieCharacter> findByMovie(Movie m) {
		ArrayList<MovieCharacter> list= new ArrayList<MovieCharacter>();
		
		Connection conn= DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		String querySQL= "SELECT * "
				+ "FROM movieCharacter "
				+ "WHERE movieID=?";
		
		try {
			pstmt= conn.prepareStatement(querySQL);
			pstmt.setLong(1, m.getId());
			
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				MovieCharacter mc= new MovieCharacter();
				mc.setId(rs.getLong("movCharID"));
				mc.setCharacter(rs.getString("character"));
				mc.setAlias(rs.getString("alias"));
				mc.setPos(rs.getInt("position"));
				mc.setPlayerId(rs.getLong("personID"));
				mc.setMovieId(rs.getLong("movieID"));
				list.add(mc);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
