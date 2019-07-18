package java_20190717;

public class SwitchDemo {
	public static void main(String[] args) {
			int m = Integer.parseInt(args[0]);
			String s = null;
			switch(m) {
			case 12: 
			case 1:
			case 2:
				s = "겨울";
				break;
			case 3: 
			case 4:
			case 5:
				s = "봄";
				break;
			case 6: 
			case 7:
			case 8:
				s = "여름";
				break;
			case 9: 
			case 10:
			case 11:
				s = "가을";
				break;
			}
			System.out.printf("%d월은  %s입니다\n", m, s);
			System.out.println("git test");
	}
}
