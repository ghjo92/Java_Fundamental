package java_20190716;

public class CalendarDemo {
	public static void main(String[] args) {
		int year = 2020;
		int month = 12;
		int day = 25;
		
		int preYear = year - 1;
		int preMonth = month -1;
		int totalCount = 0;
		
		totalCount = preYear * 365 + (preYear / 4 - preYear / 100 + preYear / 400);
		
		int[] monthArray = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		boolean isLeafYear = year%4==0 && (year%100!=0 || year%400==0);
		
		/*
		if(year%4 == 0) {
			isLeafYear = true;
			if(year%100==0) {
				isLeafYear = false;
				if(year%400==0) {
					isLeafYear = true;
				}
			}		
		}
		*/
		if(isLeafYear) {
			monthArray[1] = 29;
		}
		
		for(int i=0; i<preMonth; i++) {
			totalCount += monthArray[i];
		}
		
		totalCount += day;
		
		int dayOfWeek = totalCount %7;
		String[] oneWeek = {"일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"} ;
		System.out.println(oneWeek[dayOfWeek]);
		
	}
}
