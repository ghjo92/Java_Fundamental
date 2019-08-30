package java_20190812;

public class MemberDemo {
	public static void main(String[] args) {
		MemberDao mdao = MemberDao.getInstance();
		MemberDto m1 = new MemberDto(20,"oh","yeah");
		
		if(mdao.insert(m1))
			System.out.println("성공");
		else
			System.out.println("실패");
	}
}
