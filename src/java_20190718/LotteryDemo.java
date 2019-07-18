package java_20190718;

public class LotteryDemo {
	public static void main(String[] args) {		
		
		int[] lotto = new int[6];
		
		for(int i=0; i<lotto.length; i++) {
			
			
			int temp = (int)(Math.random() * 45)+1;
			lotto[i] = temp;
			
			
			for(int j=0; j<i; j++) {
				if(lotto[j] == lotto[i]) {
					i--;
					break;
				}				
			}
			
		}
		
		for(int i=0; i<lotto.length; i++) {
			System.out.printf("%d ", lotto[i]);
		}
	}
}
