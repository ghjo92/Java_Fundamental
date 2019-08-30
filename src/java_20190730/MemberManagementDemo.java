package java_20190730;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberManagementDemo {
	private ArrayList<Member> list;

	public MemberManagementDemo() {
		list = new ArrayList<Member>();
	}

	public void print() {
		System.out.println("*************************************************************");
		System.out.println("1. insert 2. update 3. delete 4. search 5. exit");
		System.out.println("*************************************************************");
	}

	public String console(String msg) {
		System.out.print(msg);
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}

	private void run(String selectedIndex) {
		// TODO Auto-generated method stub
		if (selectedIndex.equals("1")) {
			insert();
		} else if (selectedIndex.equals("2")) {
			System.out.println("2");
		} else if (selectedIndex.equals("3")) {
			System.out.println("3");
		} else if (selectedIndex.equals("4")) {
			System.out.println("4");
		}else if (selectedIndex.equals("5")) {
			System.out.println("5");
		}else {
			System.out.println("warning...");
			print();
			String index = console("번호를 선택하세요>");
			run(index);
		}
			

	}

	private void insert() {
		// TODO Auto-generated method stub
		String id = console("아이디를 입력하세요>");
		String name = console("이름을 입력하세요>");
		Member newMember = new Member(id, name);
		list.add(newMember);
		for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i));
		print();
		String index = console("번호를 선택하세요>");
		run(index);
	}

	public static void main(String[] args) {
		MemberManagementDemo m1 = new MemberManagementDemo();
		m1.print();
		String selectedIndex = m1.console("번호를 선택하세요>");
		m1.run(selectedIndex);
	}

}
