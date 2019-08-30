package java_20190812;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUpdateDemo {
	public static void main(String[] args) {
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con = null;
		
		PreparedStatement pstmt = null;
		
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic","kic12","kic12");
			
			StringBuffer sql = new StringBuffer();
			sql.append("Update member set addr=?, name=? where num=?");
			
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, "미국");
			pstmt.setString(2, "죠스");
			pstmt.setInt(3, 11);
			
			int Count = pstmt.executeUpdate();
			System.out.println(Count);
			
		} catch (SQLException e) {
			
		}
		
		
	}
}
