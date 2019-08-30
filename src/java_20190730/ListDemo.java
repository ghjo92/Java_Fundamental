package java_20190730;

import java.util.ArrayList;

class Product{
	int num;
	String name;
	Product(int num, String name){
		this.num = num;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Product [num=" + num + ", name=" + name + "]";
	}
	
	
}


public class ListDemo {
	public static void main(String[] args) {
		ArrayList<Product> list = new ArrayList();
		Product p1 = new Product(1,"t");
		Product p2 = new Product(2,"z");
		
		list.add(p1);
		list.add(p2);
		
				
		for(int i=0; i<list.size(); i++)
		{
			//System.out.println(i);
			list.remove(0);	
		}
		
		
		for(int i=0; i<list.size(); i++)
		{
			Product temp = (Product)list.get(i);
			System.out.println(temp);
		}
		
		for(Product pro : list)
		{
			System.out.println(pro);
		}
		
	}
}
