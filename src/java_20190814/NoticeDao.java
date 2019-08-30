package java_20190814;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NoticeDao {
	private static NoticeDao single;
	static {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private NoticeDao() {

	}

	public static NoticeDao getInstance() {
		if (single == null)
			single = new NoticeDao();
		return single;
	}

	public boolean insert(NoticeDto dto) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int index = 1;

		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?autoReconnect=true", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append(
					"insert into notice(num, writer, title, content, regdate) values(?, ?, ?, ?, str_to_date(? , '%Y-%m-%d'))");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(index++, dto.getNum());
			pstmt.setString(index++, dto.getWriter());
			pstmt.setString(index++, dto.getTitle());
			pstmt.setString(index++, dto.getContent());
			pstmt.setString(index++, dto.getRegdate());
			pstmt.executeUpdate();

			isSuccess = true;

		} catch (SQLException e) {
			System.out.println("인서트 실패");
		}

		return isSuccess;
	}

	public boolean delete(NoticeDto dto) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int index = 1;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?autoReconnect=true", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("delete from notice where num = ?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(index++, dto.getNum());
			pstmt.executeUpdate();

			isSuccess = true;

		} catch (SQLException e) {
			System.out.println("딜리트 실패");
		}

		return isSuccess;
	}

	public boolean update(NoticeDto dto) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int index = 1;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?autoReconnect=true", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();

			sql.append("update notice set writer=?, title=?, content=?, regdate=? where num =?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(index++, dto.getWriter());
			pstmt.setString(index++, dto.getTitle());
			pstmt.setString(index++, dto.getContent());
			pstmt.setString(index++, dto.getRegdate());
			pstmt.setInt(index++, dto.getNum());

			pstmt.executeUpdate();

			isSuccess = true;

		} catch (SQLException e) {
			System.out.println("업데이트 실패");
		}

		return isSuccess;
	}

	public ArrayList<NoticeDto> select() {
		ArrayList<NoticeDto> list = new ArrayList<NoticeDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?autoReconnect=true", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("select num, writer, title, content, date_format(regdate, '%y-%m-%d') from notice");
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int index = 1;
				int num = rs.getInt(index++);
				String writer = rs.getString(index++);
				String title = rs.getString(index++);
				String content = rs.getString(index++);
				String regdate = rs.getString(index++);
				
				list.add(new NoticeDto(num, writer, title, content, regdate));
			}
			
			
		} catch (SQLException e) {
			System.out.println("설렉트실패");
		}

		return list;
	}

}
