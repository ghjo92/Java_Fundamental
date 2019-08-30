package java_20190813;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeptDao {
	private static DeptDao single;

	static {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private DeptDao() {

	}

	public static DeptDao getInstance() {
		if (single == null) {
			single = new DeptDao();
		}
		return single;
	}
	
	public boolean insert(DeptDto dto) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?autoReconnect=true", "kic12", "kic12");			
			StringBuffer sql = new StringBuffer();
			sql.append("insert into dept(deptno, dname, loc) values(?, ?, ?)");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, dto.getNo());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getLoc());
			
			pstmt.executeUpdate();
			
			isSuccess = true;
			
		} catch (SQLException e) {
			System.out.println("인서트 실패");
		}
		
		
		
		return isSuccess;
	}
	public boolean delete(DeptDto dto) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			 con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?autoReconnect=true", "kic12", "kic12");
			 StringBuffer sql = new StringBuffer();
			 sql.append("delete from dept where deptno = ?");
			 pstmt = con.prepareStatement(sql.toString());
			 pstmt.setInt(1, dto.getNo());
			 pstmt.executeUpdate();
			 
			 isSuccess = true;		 
			 			 			 
		} catch (SQLException e) {
			System.out.println("딜리트 실패");
		}
		
		return isSuccess;
	}
	public boolean update(DeptDto dto) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?autoReconnect=true", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("update dept set deptno=?, dname=?, loc=? where deptno=?");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, dto.getNo());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getLoc());
			pstmt.setInt(4, dto.getNo());		

			
			System.out.println(dto.getNo());
			System.out.println(dto.getName());
			System.out.println(dto.getLoc());
			
			pstmt.executeUpdate();			
			
			isSuccess = true;
			
		} catch (SQLException e) {
			System.out.println("업데이트 실패");
		}
		
		return isSuccess;
	}
	
	public ArrayList<DeptDto> select(){
		ArrayList<DeptDto>list = new ArrayList<DeptDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?autoReconnect=true", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("select deptno, dname, loc from dept order by deptno desc");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.executeQuery();
			
			ResultSet rs = pstmt.getResultSet();
			while(rs.next())
			{
				int no = rs.getInt(1);
				String dname = rs.getString(2);
				String dloc = rs.getString(3);
				
				//System.out.printf("%d %s %s\n", no, dname, dloc);
				
				list.add(new DeptDto(no, dname, dloc));
			}
			
		} catch (SQLException e) {
			System.out.println("셀렉트 오류");
		}
		
		
		return list;
	}
	
}
