package java_20190723;

public class AdminDemo {
	public static void main(String[] args) {
		Admin a = new Admin();
		a.setId("1");
		a.setPwd("222");
		a.setEmail("3333");
		a.setLevel(444);
		
		System.out.printf("%s %s %s %d", a.getId(), a.getPwd(), a.getEmail(), a.getLevel());
	}
}
