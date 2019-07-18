package java_20190717;

public class WhileDemo {
	public static void main(String args[]) {
		int sum =0;
		int i = 1;
		while(i<=10) {
			sum += i;
			i++;
		}
		System.out.println(sum);
		
		int f = 2;
		while(f<=9) {
			int s =2;
			while(s<=9) {
				System.out.printf("%d * %d = %d\n", f,s,f*s);
				s++;
			}
			f++;
		}
	}	
}
