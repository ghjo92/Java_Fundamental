package java_20190730;

import java.util.ArrayList;

public class GenericDemo {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		
		for(int i=0; i<a.size(); i++)
		{
			Integer temp = a.get(i);
			System.out.println(temp);
		}
	}
}
