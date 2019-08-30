package java_20190731;

import java.util.Calendar;

public class CalendarDemo {
	public static void main(String[] args) {
		 Calendar c = Calendar.getInstance();
		 int year = c.get(Calendar.YEAR);
		 int month = c.get(Calendar.MONTH)+1;
		 int day = c.get(Calendar.DATE);
		 
		 int hour = c.get(Calendar.HOUR);
		 int min = c.get(Calendar.MINUTE);
		 int sec = c.get(Calendar.SECOND);
		
		 Calendar2 c2 = new Calendar2();
		 c2.print(2019, 7, 31);
		 System.out.printf("%d년%d월%d일 %d시 %d분 %d초%n", year,month, day, hour, min, sec );
		 c2.print(2019, 7);
	}
}
