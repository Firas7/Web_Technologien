package DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Person {
	private long id;
	
	private String name;
	private char sex;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void insert() {
		Connection conn= DBConnection.getConnection();
		
		String idSQL= "SELECT seq_PersonID.nextval FROM DUAL";
		
		Statement stmt= null;
		
		try {
			stmt= conn.createStatement();
			ResultSet rs= stmt.executeQuery(idSQL);
			
			while(rs.next()) {
				id= rs.getLong(1);
			}
			
			PreparedStatement pstmt = null;
			
			String insertSQL="INSERT INTO Person VALUES(?, ?, ?)";
			
			try {
				pstmt= conn.prepareStatement(insertSQL);
				pstmt.setLong(1, id);
				pstmt.setString(2, name);
				pstmt.setString(3, Character.toString(sex));
				
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
		String updateSQL= "UPDATE person SET name=?, sex=? "
				+ "WHERE personID=?";
		try {
			pstmt= conn.prepareStatement(updateSQL);
			pstmt.setString(1, name);
			pstmt.setInt(2, sex);
			pstmt.setLong(3, id);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete() {
		Connection conn= DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		String deleteSQL= "DELETE FROM person WHERE personID=?";
		
		try {
			pstmt= conn.prepareStatement(deleteSQL);
			pstmt.setLong(1, id);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
