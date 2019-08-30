package java_20190730;

import java.util.Iterator;
import java.util.TreeSet;

public class SetDemo {
	public static void main(String[] args) {
		//TreeSet은 오름차순 정렬한다.
		TreeSet set = new TreeSet();
		
		while(true) {
			int random = (int)(Math.random()*45)+1;
			set.add(random);
			if(set.size()==6) break;
		}
					
		Iterator i = set.iterator();
		while(i.hasNext()) {
			int temp = (Integer)i.next();
			System.out.println(temp+'\t');
		}
	}
}
