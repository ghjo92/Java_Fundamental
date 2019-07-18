package java_20190716;

public class IfDemo {
	public static void main(String args[]) {
		int month  = Integer.parseInt(args[0]);
		//System.out.println(month);
		
		String ss = null;
		if(month == 12|| month == 1||month == 2){
			ss = "겨울";
		}else if(month >= 3&& month <= 5){
			ss = "봄";
		}else if(month >= 6&& month <= 8){
			ss = "여름";
		}else if(month >= 9&& month <= 11){
			ss = "가을";
		}else {
			ss = "없음";
		}		
		System.out.println(month + "월은 " + ss +"입니다.");
	}
}
