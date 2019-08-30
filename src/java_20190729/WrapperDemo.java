package java_20190729;

import java.util.ArrayList;

public class WrapperDemo {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Integer(100));
		System.out.println(list.get(0));
		
		//1. primitive data type => wrapper class (생성자 => new 생성자(10));
		Integer i2 = new Integer(10);
		Integer i3 = new Integer(11);
		i2.valueOf(15);
		
		//2. String => wrapper class(Interger.valueOf("10"));
		String str = "10";
		Integer i = Integer.valueOf(str);
		System.out.println(i);
		
		//3. wrapper class => primitive data type(intValue()) 연산을 위해서.
		int itemp = i2.intValue()+ i3.intValue();

		//4. String class => primitive data type(Integer.parseInt)
		System.out.println(str);
		System.out.println(Integer.parseInt(str));
		
		//5. primitive data type => String class
		str = Integer.toString(itemp);
		str = String.valueOf(itemp);
		
		//auto-boxing : primitive data type을 자동으로 wrapper
		Integer i4 = 30;
		Integer i5 = i4;
		i4 = 40;
		int i6 = i4;
		System.out.println(i4);
		System.out.println(i5);
	}
}

