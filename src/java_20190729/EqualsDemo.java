package java_20190729;

import java.util.HashSet;

class Car {
	String modelNumber;
	String color;

	public Car(String modelNumber, String color) {
		this.modelNumber = modelNumber;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Car [modelNumber=" + modelNumber + ", color=" + color + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((modelNumber == null) ? 0 : modelNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (modelNumber == null) {
			if (other.modelNumber != null)
				return false;
		} else if (!modelNumber.equals(other.modelNumber))
			return false;
		return true;
	}

}

public class EqualsDemo {
	public static void main(String[] args) {
		Car c1 = new Car("10101010", "black");
		Car c2 = new Car("10101010", "black");
		// 참조에 대하여 true, false
		System.out.println(c1 == c2);
		System.out.println(c1.equals(c2));

		int hashCode1 = c1.hashCode();
		int hashCode2 = c2.hashCode();
		System.out.println(hashCode1);
		System.out.println(hashCode2);
		
		Car c3 = new Car("10101010", "white");
		Car c4 = c3;
		
		System.out.println(c1 == c4);
		System.out.println(c3.equals(c4));
		
		int hashCode3 = c3.hashCode();
		int hashCode4 = c4.hashCode();
		System.out.println(hashCode3);
		System.out.println(hashCode4);
		
		
		String s1 = "test";
		String s2 = "test";
		
		System.out.println(s1 == s2);
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		System.out.println(c1.toString());
		
		
		HashSet set = new HashSet();
		set.add(c1);
		set.add(c4);
		System.out.println(set.size());
	}
}
