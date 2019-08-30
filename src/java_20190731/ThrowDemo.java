package java_20190731;

public class ThrowDemo {
	public static double withdraw(String account, int amount)
	throws IncorrectAccountException, InsufficientBalanceException{
		double mybalance = 10000;
		String myAccount = "123-12-12345";
		if(myAccount.equals(account)) {
			if(mybalance >= amount)
				mybalance -= amount;
			else {
				throw new InsufficientBalanceException("잔고가 부족합니다");
			}
		}else {
			throw new IncorrectAccountException("잘못된 계정입니다");
		}
		return mybalance;
	}
	
	
	public static void main(String[] args) {
		double balance = 0;
		
		try {
			balance = withdraw("123-12-1234", 100000);
		}catch (IncorrectAccountException e){
			System.err.println(e.getMessage());
		}catch (InsufficientBalanceException e) {
			System.err.println(e.getMessage());
		}
		System.out.println("예외땜에 호출안됨?");
	}
}
