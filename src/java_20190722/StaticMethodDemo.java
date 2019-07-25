package java_20190722;

public class StaticMethodDemo {
	String name;
	static double interestRate;
	
	public void m1() {
		System.out.println("m1() 메서드 호출");
	}
	
	public void m2() {
		//instance method에서는 
		//instance 변수, static 변수 사용 가능
		//instance 메소드, static 메소드 사용가능
		name = "성영한 ";
		interestRate = 0.1;
		m1();
		m3();
	}
	
	public static void m3() {
		System.out.println("m3() 메서드 호출");
	}
	
	
	public static void m4() {
		//static 메소드에서는 this를 사용할 수 없음.
		//instance method에서는 
		//instance 변수 불가능, static 변수 사용 가능
		//instance 메소드 불가능, static 메소드 사용가능
		//name = "홍길동 ";
		interestRate = 0.3;
		//m1();
		m3();
	}
	public static void main(String[] args) {		
		m3();
		m4();
		interestRate = 1;
		//name = "s"; 
		StaticMethodDemo s1 = new StaticMethodDemo();
		s1.m1();
		s1.m2();
	}
}
