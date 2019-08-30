package homework2;

public class MemberFindDtoDemo {
	public static void main(String[] args) {
		// 1. 객체 생성
		MemberFindDto f1 = new MemberFindDto(100, "asdf@z.com", "zxqwas", "2019/08/09/09:00:00", "2019/08/09/09:00:03");
		// 2. 객체 출력
		System.out.println(f1.GetCode());
		// 3. 객체 수정
		f1.SetCode("zxcv");
		// 4. 수정된 객체 출력
		System.out.println(f1.GetCode());
		// 5. 다른 객체를 생성하여 1~4 반복

	}
}
