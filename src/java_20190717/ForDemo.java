package java_20190717;

public class ForDemo {
	public static void main(String args[]) {
		
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0)
				sum = sum + i;
		}
		System.out.printf("총합 : %d\n", sum);
		for(int f =2; f<=9; f++) {
			for(int s=1; s<=9; s++)
				System.out.printf("%d * %d = %d\n", f,s,f*s);
		}
		for(int f =0; f<5; f++) {
			for(int s=0; s<5-f; s++) {
				System.out.printf("*");
			}System.out.printf("\n");
		}
		
		
		for(int f =9; f>=2; f--) {
			for(int s=1; s<=9; s++) {
				System.out.printf("%d * %d = %d\n", f,s,f*s);
			}
		}	
	}
}
