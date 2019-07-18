package java_20190718;

public class ArrayDemo {
	public static void main(String args[]) {
		int[] a = new int[4];
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		a[3] = 4;
		System.out.println(a[0]);
		int sum = 0;
		for(int i=0; i<a.length; i++) {
			int temp = a[i];
			sum += temp;
			System.out.println(temp);
		}
			
		System.out.printf("합은 %d 입니다.\n", sum);
		
		int[] b= {10,20,30,40};
		for (int i = 0; i < b.length; i++) {
			System.out.printf("%d%n",b[i]);	
		}
		
	}	
}
