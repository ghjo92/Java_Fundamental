package java_20190812;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcSelectDemo {
	public static void main(String[] args) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con = null;		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic","kic12","kic12");
			
			StringBuffer sql = new StringBuffer();
			sql.append("select num, addr, name from member");
			
			pstmt = con.prepareStatement(sql.toString());			
			//pstmt.setString(1, "addr");
			//pstmt.setString(2, "name");
			//pstmt.setString(3, "addr");
			//pstmt.setString(4, "member");
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt(1);
				String name = rs.getString(2);
				String addr = rs.getString(3);
				System.out.println(num+" "+name+" "+addr+"\n");
			}
			
		} catch (SQLException e) {
			System.out.println("?");	
		}
	}
}
