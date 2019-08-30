package java_20190812;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//data access object
public class MemberDao {	
	
	//1.singleton 코딩
	private static MemberDao single;
	private MemberDao() {
		
		
	}
	public static MemberDao getInstance() {
		if(single == null) {
			single = new MemberDao();
		}
		return single;
	}
	
	
	public boolean insert(MemberDto m) {
		boolean isSuccess = false;
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
			sql.append("Insert into member(num,name,addr) values(?,?,?)");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, m.getNum());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getAddr());
			
			pstmt.executeUpdate();			
			isSuccess = true;

			
		} catch (Exception e) {
			System.out.println("에러에러");
		}
		
		return isSuccess;
	}
	
	
}
