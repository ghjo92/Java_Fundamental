package java_20190722;

public class MemberDemo {
	public static void main(String[] args) {
		Member m = new Member();
		m.setName("zz");
		System.out.println(m.getName());
		m.setAddress("주소!");
		//m.setAge(31);
		System.out.println(m.getAge());
		System.out.println(m.getRegdate());
		
	}
}
