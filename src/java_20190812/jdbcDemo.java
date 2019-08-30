package java_20190812;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbcDemo {
	public static void main(String[] args) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Driver Load Success");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Load Fail");
		}
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/kic?autoReconnect=true",//url
					"kic12",//사용자
					"kic12"//비밀번호		
					);
			
			StringBuffer sql = new StringBuffer();
			sql.append("insert into member(num, name, addr)");
			sql.append("values(?,?,?)");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, 11);
			pstmt.setString(2, "베조스");
			pstmt.setString(3, "캐나다");
			
			int resultCount  =  pstmt.executeUpdate();
			
			System.out.println("갱신된 행의 수 :"  +resultCount);
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
