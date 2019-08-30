package java_20190723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CalendarDemo {
	public static String console() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
	}
	
	public static void main(String[] args) throws IOException{

		while(true) {
			System.out.println("날짜를 입력하세요>");
			String readLine = console();
			if(readLine.equals("exit"))
				break;
			
			String[] data = readLine.split(" ");
			int dataLength = data.length;
			
			Calendar c1 = new Calendar();
			
			if(dataLength == 1) {
				//String syear = data[0];
				int year = Integer.parseInt(data[0]);
				c1.print(year);
			}else if(dataLength == 2) {
				//String syear = data[0];
				//String smonth = data[1];
				int year = Integer.parseInt(data[0]);
				int month = Integer.parseInt(data[1]);				
				c1.print(year, month);
			}else if(dataLength == 3) {
				//String syear = data[0];
				//String smonth = data[1];
				//String sday = data[2];
				int year = Integer.parseInt(data[0]);
				int month = Integer.parseInt(data[1]);
				int day = Integer.parseInt(data[2]);				
				c1.print(year, month, day);
			}else {
				
			}
			
			
			
		}
		
	}
}
