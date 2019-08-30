package java_20190812;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class JdbcDeleteDemo {
	public static void main(String[] args) {
		//1. 드라이버 로드
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		//2. connection 객체 생성
		Connection con = null;
		//3. preparedStatement 객체 생성
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?autoReconnect=true", "kic12", "kic12");
			
			StringBuffer sql = new StringBuffer();
			sql.append("delete from member ");
			sql.append("where num = ?");
			
			//3. preparedStatement 객체 생성
			pstmt = con.prepareStatement(sql.toString());
			//3-1. 바인딩변수가 있다면 바인딩변수 설정
			pstmt.setInt(1, 3);
			
			
			//4. excuteUpdate() 메서드로 SQL(insert, update, delete)문 전송
			int resultCount = pstmt.executeUpdate();
			System.out.println("삭제된 행의수 "+resultCount);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt !=null) pstmt.close();
				if(con!=null)con.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}

		
		
		
	}
}
