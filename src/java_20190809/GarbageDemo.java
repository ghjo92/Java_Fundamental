package java_20190809;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;

class A extends Thread{
	public void run() {
		System.out.println("zzThreadzz");
	}	
}

class B implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("thread2zz");
	}
	
}
class Customer{
	String name;
	Customer(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

class CustomerDao{
	public Customer[] getCustomer() {
		Customer[] cs = new Customer[10];
		Customer c1 = new Customer("성영한1");
		Customer c2 = new Customer("성영한2");
		Customer c3 = new Customer("성영한3");
		Customer c4 = new Customer("성영한4");
		Customer c5 = new Customer("성영한5");
		Customer c6 = new Customer("성영한6");
		Customer c7 = new Customer("성영한7");
		Customer c8 = new Customer("성영한8");
		Customer c9 = new Customer("성영한9");
		Customer c10 = new Customer("성영한10");
		cs[0] = new Customer("성영한1");
		cs[1] = new Customer("성영한2");
		cs[2] = new Customer("성영한3");
		cs[3] = c4;
		cs[4] = c5;
		cs[5] = c6;
		cs[6] = c7;
		cs[7] = c8;
		cs[8] = c9;
		cs[9] = c10;
		
		
		return cs;
	}
	
	public ArrayList<Customer> getCustomers(){
		ArrayList<Customer> list = new ArrayList<Customer>();
		list.add(new Customer("성영한1"));
		list.add(new Customer("성영한2"));
		list.add(new Customer("성영한3"));
		list.add(new Customer("성영한4"));
		list.add(new Customer("성영한5"));
		list.add(new Customer("성영한6"));
		list.add(new Customer("성영한7"));
		list.add(new Customer("성영한8"));
		list.add(new Customer("성영한9"));
		list.add(new Customer("성영한10"));
		
		return list;
	}
}


public class GarbageDemo {
	public static void main(String[] args) {
		//Dao(Data access object)
		CustomerDao cdao = new CustomerDao();
		
		Customer[] customers = cdao.getCustomer();
		
		for (Customer customer : customers) {
			System.out.println(customer.getName());
		}
		
		ArrayList<Customer> list = cdao.getCustomers();
		for (Customer customer : list) {
			System.out.println(customer.getName());
		}
		
		
		/*
		A a = new A();
		a.start();
		System.out.println("a~~~~~");
		
		B b = new B();
		Thread t = new Thread(b);
		t.start();
		System.out.println("B~~~~~~");
		*/
		
			
		Calendar c = Calendar.getInstance();
		GregorianCalendar c1 = new GregorianCalendar();	
	}
	//Calendar 클래스의 메서드만 사용할 수 있음.
	//단, GregorianCalendar 클래스에서 overriding된 메서드는 사용 가능.	
	public static Calendar getInstance() {
		//Calendar c = new GregorianCalendar();
		//return c;
		return new GregorianCalendar();
	}
	//인터페이스들끼리는 다중상속가능.
}
