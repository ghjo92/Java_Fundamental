package java_20190731;

import java.util.Calendar;

/**
 Calendar 클래스는 년도별, 월별, 요일을 구할 수 있는 클래스 입니다.
 */
public class Calendar2 {
	public static final int SUNDAY = 0;
	public static final int MONDAY = 1;
	public static final int TUESDAY = 2;
	public static final int WEDNESDAY = 3;
	public static final int THURSDAY = 4;
	public static final int FRIDAY = 5;
	public static final int SATURDAY = 6;

	public int getLastday(int year, int month) {
		int[] monthArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		boolean isLeafYear = isLeafYear(year);
		if (isLeafYear) {
			monthArray[1] = 29;
		}

		return monthArray[month - 1];
	}

	private boolean isLeafYear(int year) {
		return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
	}

	public int getCount(int year, int month, int day) {
		int preYear = year - 1;
		int preMonth = month - 1;
		int totalCount = 0;

		totalCount = preYear * 365 + (preYear / 4 - preYear / 100 + preYear / 400);

		int[] monthArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		boolean isLeafYear = isLeafYear(year);

		if (isLeafYear) {
			monthArray[1] = 29;
		}

		for (int i = 0; i < preMonth; i++) {
			totalCount += monthArray[i];
		}

		totalCount += day;

		return totalCount;
	}
	/**
	 * 
	 년월일에 해당하는 요일출력
	 */
	public void print(int year, int month, int day) {
		Calendar c = Calendar.getInstance();
		c.set(year, month-1, day);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
		String[] oneWeek = { "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일" };
		/*
		 * if(dayOfWeek == Calendar.MONDAY) {
		 * 
		 * }else if(dayOfWeek == Calendar.TUESDAY) {
		 * 
		 * }else if(dayOfWeek == Calendar.WEDNESDAY) {
		 * 
		 * }else if(dayOfWeek == Calendar.THURSDAY) {
		 * 
		 * }else if(dayOfWeek == Calendar.FRIDAY) {
		 * 
		 * }else if(dayOfWeek == Calendar.SATURDAY) {
		 * 
		 * }else if(dayOfWeek == Calendar.SUNDAY) {
		 * 
		 * }
		 */

		System.out.printf("%d년 %d월 %d일은 %s입니다.%n", year, month, day, oneWeek[dayOfWeek]);
	}
	/**
	 해당하는 월의 달력을 출력
	 */
	public void print(int year, int month) {
		Calendar c = Calendar.getInstance();
		c.set(year, month-1, 1);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - 1 ;

		System.out.printf("%d년 %d월%n", year, month);
		System.out.printf("일\t월\t화\t수\t목\t금\t토\n");

		for (int i = 0; i < dayOfWeek; i++)
			System.out.printf("\t");
		for (int i = 1; i <= c.getActualMaximum(Calendar.DATE); i++) {
			System.out.printf("%d", i);
			if ((i + dayOfWeek) % 7 == 0) {
				System.out.printf("\n");
			} else {
				System.out.printf("\t");
			}
		}
		System.out.printf("\n");
	}
	
	/**
	 해당하는 년도의 달력을 출력
	 */
	public void print(int year) {
		for (int i = 0; i < 12; i++) {
			if(i%2==0)
			print(year, i+1);
		}
	}
}
