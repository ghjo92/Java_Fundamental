package java_20190722;

public class OverloadingDemo {
	public void print(String str) {
		System.out.println(str);
	}

	public void print(int i) {
		System.out.println(i);
	}
	
	public void print(double d) {
		System.out.println(d);
	}
	
	public void print(boolean b) {
		System.out.println(b);
	}
	
	public static void main(String[] args) {
		OverloadingDemo o1 = new OverloadingDemo();
		o1.print("gggg");
		o1.print(123);
		o1.print(12.34);
		o1.print(true);
		
	}
}
