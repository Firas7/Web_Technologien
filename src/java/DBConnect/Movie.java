package DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Movie {
	private long id;
	
	private String title;
        private int regisseur;
	private int year;
	private char type;
	
        public Movie(){}
        
        public Movie(long id, String title, int regisseur, int year, char type){
            this.id=id;
            this.title=title;
            this.regisseur=regisseur;
            this.year=year;
            this.type=type;
        }
	// Nur fuer Movie-Factory.
	// Bessere Moeglichkeit vielleicht da?
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

        public int getRegisseur() {
		return regisseur;
	}

	public void setRegisseur(int regisseur) {
		this.regisseur = regisseur;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}
	
	public void insert() {
		Connection conn= DBConnection.getConnection();
		
		String idSQL= "SELECT seq_MovieID.nextval FROM DUAL";
		
		Statement stmt= null;
		
		try {
			stmt= conn.createStatement();
			ResultSet rs= stmt.executeQuery(idSQL);
			
			while(rs.next()) {
				id= rs.getLong(1);
			}
			
			PreparedStatement pstmt = null;
			
			//INSERT INTO Movie VALUES(MovieID, Title, Year, Type);
			String insertSQL="INSERT INTO Movie VALUES(?, ?, ?, ?, ?)";
			
			try {
				pstmt= conn.prepareStatement(insertSQL);
				pstmt.setLong(1, id);
				pstmt.setString(2, title);
                                pstmt.setInt(3, regisseur);
				pstmt.setInt(4, year);
				pstmt.setString(5, Character.toString(type));
				
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
		String updateSQL= "UPDATE movie SET title=?, year=?, "
				+ "type=? WHERE movieID=?";
		try {
			pstmt= conn.prepareStatement(updateSQL);
			pstmt.setString(1, title);
			pstmt.setInt(2, year);
			pstmt.setString(3, Character.toString(type));
			pstmt.setLong(4, id);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete() {
		Connection conn= DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		String deleteSQL= "DELETE FROM movie WHERE movieID=?";
		
		try {
			pstmt= conn.prepareStatement(deleteSQL);
			pstmt.setLong(1, id);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return title + " " + id;
	}
}
