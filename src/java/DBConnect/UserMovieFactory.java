package DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserMovieFactory {
	public static List<UserMovie> findByMovieId(long id) {
		ArrayList<UserMovie> list = new ArrayList<UserMovie>();
		
		
		PreparedStatement pstmt = null;
		String querySQL= "SELECT * FROM usermovie WHERE movieID = ?";
		
		try {
                    Connection conn= DBConnection.getConnection();
		
                    pstmt= conn.prepareStatement(querySQL);
                    pstmt.setLong(1, id);
			
                    ResultSet rs= pstmt.executeQuery();
			
                    while(rs.next()) {
                        UserMovie us= new UserMovie();
                        us.setUserName(rs.getString("UserName"));
                        us.setMovieID(rs.getLong("movieID"));
                        list.add(us);
                    }
                    return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<UserMovie> findByUserName(String name) {
		ArrayList<UserMovie> list = new ArrayList<UserMovie>();
		
		
		PreparedStatement pstmt = null;
		String querySQL= "SELECT * FROM usermovie WHERE UserName = ?";
		
		try {
                    Connection conn= DBConnection.getConnection();
		
                    pstmt= conn.prepareStatement(querySQL);
                    pstmt.setString(1, name);
			
                    ResultSet rs= pstmt.executeQuery();
			
                    while(rs.next()) {
                        UserMovie us= new UserMovie();
                        us.setUserName(rs.getString("UserName"));
                        us.setMovieID(rs.getLong("movieID"));
                        list.add(us);
                    }
                    return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
