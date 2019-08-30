package java_20190814;

import java.util.ArrayList;
import java.util.Iterator;

public class NoticeDemo {
	public static void main(String[] args) {
		
		NoticeDao dao = NoticeDao.getInstance();
		
		dao.insert(new NoticeDto(32, "조기", "조기제목", "조기내용", "2019-08-14"));
		dao.delete(new NoticeDto(7, "", "", "", ""));
		dao.update(new NoticeDto(10, "조기업", "조기업뎃", "조기업데이트", "2019-08-15"));
		ArrayList<NoticeDto> arr = dao.select();
		for (NoticeDto noticeDto : arr) {
			System.out.printf("%d %s %s %s %s%n", noticeDto.getNum(), noticeDto.getWriter(), noticeDto.getTitle(), noticeDto.getContent(), noticeDto.getRegdate());	
		}
		
	}
}
