package java_20190805;

import java.util.Scanner;

import bonus.Utility;

public class APIExamCaptchaDemo {
	

	
	public static void main(String[] args) {
		String id = "6_dKNl9mGqkwD01Alo_I";
		String secret = "UXbzdcKxOg";
		String key = Utility.getCaptchaKey(id, secret);
		boolean isSuccess = Utility.isCaptchaImage(id, secret, key);
		if(isSuccess) {
			System.out.println("이미지확인ㄱ");
			String value = Utility.console("값을 입력하세요.");
			
			boolean result  = Utility.getCaptchaResult(id, secret, key, value);
		}else {
			System.out.println("이미지생성실패");			
		}
		
		System.out.println(key);
	}
}
