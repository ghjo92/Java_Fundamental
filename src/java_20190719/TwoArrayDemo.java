package java_20190719;

public class TwoArrayDemo {
	public static void main(String[] args) {
		int[][] a = new int[3][2];
		a[0][0]= 10;
		a[0][1]= 20;
		a[1][0]= 30;
		a[1][1]= 40;
		a[2][0]= 50;
		a[2][1]= 60;
		
		int[][] b = {{10,20},{30,40},{50,60}};
		
		for(int i=0; i<a.length; i++) {
			System.out.println(a.length);
			for(int j=0; j<a[i].length; j++) {
				System.out.print(a[i].length + " ");
				System.out.println(a[i][j]);
			}
		}
		
		int[] c = {10,20,30};
		
		for(int temp :c) {
			System.out.println(temp);
		}
		
		int[] e = {1,2,3,4,5,6,7};
		int[] f = new int[4];
		
		System.arraycopy(e, 3, f, 2, 2);
		for(int i=0; i<f.length; i++) {
			System.out.println(f[i]);
		}
		
	}
}
