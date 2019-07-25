package java_20190719;

public class ArrayCopyDemo {
	public static void main(String[] args) {
		String[] fruits = {"apple", "banana","watermelon","blueberry"};
		String[] temp = new String[6];
		temp[4] = "peach";
		temp[5] = "raseberry";
		System.arraycopy(fruits, 0, temp, 0, fruits.length);
		
		for(String s : temp) {
			System.out.println(s);
		}
	}
}
