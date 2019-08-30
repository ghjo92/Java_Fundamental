package java_20190730;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapDemo {
	public static void main(String[] args) {
		//생성
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		//할당
		map.put("1", 111111);
		map.put("2", 211111);
		map.put("3", 311111);
		map.put("4", 411111);
		map.put("5", 511111);
		map.put("1", 611111);
		
		
		//출력
		Integer value = map.get("1");
		System.out.println(value);
		
		Set<String> set = map.keySet();
		Iterator<String> i = set.iterator();
		while(i.hasNext()) {
			String k = i.next();
			Integer v = map.get(k);
			System.out.println(k);
			System.out.println(v);
		}
		
	}
}
