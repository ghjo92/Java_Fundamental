package java_20190723;

public class PrimeNumber {
	public int[] getPrimeNumber(int temp) {

		/*
		 * boolean[] isPrime= new boolean[temp];
		 * 
		 * for(int i=2; i<temp; i++) isPrime[i] = true;
		 * 
		 * 
		 * for(int i=2; i*i<=temp; i++) { if(isPrime[i]==true) { for(int j=2; i*j<temp;
		 * j++) { isPrime[i*j]=false; } } } for(int i=2; i<temp; i++) if( isPrime[i] ==
		 * true) System.out.printf("%d ", i);
		 */
		int cnt = 0;
		int[] check = new int[temp];

		for (int i = 2; i <= temp; i++) {
			for (int j = 2; j <= i; j++) {
				if (j == i) {
					check[cnt] = i;
					cnt++;
				}

				if (i % j == 0)
					break;
			}
		}
		int[] arr = new int[cnt];
		System.arraycopy(check, 0, arr, 0, cnt);

		return arr;
	}

	public void printPrimeNumber(int temp) {

		for (int i = 2; i <= temp; i++) {
			for (int j = 2; j <= i; j++) {
				if (j == i) {
					System.out.printf("%d ", i);
				}
				if (i % j == 0)
					break;
			}
		}
		return;
	}
}
