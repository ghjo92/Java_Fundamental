package java_20190723;

public class PrimeNumberDemo {
	public static void main(String[] args) {
		PrimeNumber p1 = new PrimeNumber();
		
		p1.printPrimeNumber(100);
		System.out.println("");
		int[] array = p1.getPrimeNumber(100);
		for(int i:array)
			System.out.printf("%d ", i);
	}
}
