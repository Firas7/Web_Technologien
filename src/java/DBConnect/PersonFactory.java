package DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonFactory {
	public static Person findById(long id) {
		Person p= new Person();
		
		Connection conn= DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		String querySQL= "SELECT * FROM person WHERE personID=?";
		
		try {
			pstmt= conn.prepareStatement(querySQL);
			pstmt.setLong(1, id);
			
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				p.setId(rs.getLong("personID"));
				p.setName(rs.getString("name"));
				p.setSex(rs.getString("sex").charAt(0));
			}
			return p;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<Person> findByName(String name) {
		ArrayList<Person> list= new ArrayList<Person>();
		
		Connection conn= DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		String querySQL= "SELECT * FROM person WHERE name=?";
		
		try {
			pstmt= conn.prepareStatement(querySQL);
			pstmt.setString(1, name);
			
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				Person p= new Person();
				p.setId(rs.getLong("personID"));
				p.setName(rs.getString("name"));
				p.setSex(rs.getString("sex").charAt(0));
				list.add(p);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<Person> findByAnyName(String substr) {
		ArrayList<Person> list= new ArrayList<Person>();
		
		Connection conn= DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		String querySQL= "SELECT * FROM person WHERE UPPER(name) LIKE UPPER(?)";
		
		// '%?%'
		
		try {
			pstmt= conn.prepareStatement(querySQL);
			pstmt.setString(1, "%" + substr + "%");
			
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				Person p= new Person();
				p.setId(rs.getLong("personID"));
				p.setName(rs.getString("name"));
				p.setSex(rs.getString("sex").charAt(0));
				list.add(p);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Person findByMovieCharacter(MovieCharacter mc) {
		Person p= new Person();
		
		Connection conn= DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		String querySQL= "SELECT * "
				+ "FROM person "
				+ "WHERE personID=?";
		
		try {
			pstmt= conn.prepareStatement(querySQL);
			pstmt.setLong(1, mc.getPlayerId());
			
			ResultSet rs= pstmt.executeQuery();
			
			while(rs.next()) {
				p.setId(rs.getLong("personID"));
				p.setName(rs.getString("name"));
				p.setSex(rs.getString("sex").charAt(0));
			}
			return p;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
