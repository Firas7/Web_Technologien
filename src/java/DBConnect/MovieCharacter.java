package DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MovieCharacter {
	private long id;
	
	private String character;
	private String alias;
	private int position;
	
	private long personID;
	private long movieID;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCharacter() {
		return character;
	}


	public void setCharacter(String character) {
		this.character = character;
	}


	public String getAlias() {
		return alias;
	}


	public void setAlias(String alias) {
		this.alias = alias;
	}


	public int getPos() {
		return position;
	}


	public void setPos(int position) {
		this.position = position;
	}


	public long getPlayerId() {
		return personID;
	}


	public void setPlayerId(long personID) {
		this.personID = personID;
	}


	public long getMovieId() {
		return movieID;
	}


	public void setMovieId(long movieID) {
		this.movieID = movieID;
	}
	
	public void insert() {
		Connection conn= DBConnection.getConnection();
		
		String idSQL= "SELECT seq_MovCharID.nextval FROM DUAL";
		
		Statement stmt= null;
		
		try {
			stmt= conn.createStatement();
			ResultSet rs= stmt.executeQuery(idSQL);
			
			while(rs.next()) {
				id= rs.getLong(1);
			}
			
			PreparedStatement pstmt = null;
			
			//INSERT INTO MovieCharacter VALUES(MovCharID, Character, Alias, Position, PersonID, MovieID);
			String insertSQL="INSERT INTO MovieCharacter VALUES(?, ?, ?, ?, ?, ?)";
			
			try {
				pstmt= conn.prepareStatement(insertSQL);
				pstmt.setLong(1, id);
				pstmt.setString(2, character);
				pstmt.setString(3, alias);
				pstmt.setInt(4, position);
				pstmt.setLong(5, personID);
				pstmt.setLong(6, movieID);
				
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
		String updateSQL= "UPDATE movieCharacter SET character=?, alias=?, "
				+ "position=?, personID=?, movieID=? WHERE movCharID=?";
		try {
			pstmt= conn.prepareStatement(updateSQL);
			pstmt.setString(1, character);
			pstmt.setString(2, alias);
			pstmt.setInt(3, position);
			pstmt.setLong(4, personID);
			pstmt.setLong(5, movieID);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete() {
		Connection conn= DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		String deleteSQL= "DELETE FROM movieCharacter WHERE movCharID=?";
		
		try {
			pstmt= conn.prepareStatement(deleteSQL);
			pstmt.setLong(1, id);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
