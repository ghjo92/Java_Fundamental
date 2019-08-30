package java_20190729;

public class StringDemo {
	public static void main(String[] args) {
		String s1 = new String("test");
		String s2 = new String("test");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		
		String s3 ="abc";
		String s4 ="abc";
		System.out.println(s3==s4);
		System.out.println(s3.equals(s4));
		s3 += s4;
		s3 = "asdf";
		System.out.println(s3);
		
		
		String fileName = "abc.qwer.asdf.doc";
		if(fileName.endsWith("zip")) {
			System.out.println("압축파일입니다.");
		}
		else if(fileName.endsWith("doc")) {
			System.out.println("워드문서입니다.");
		}else {
			System.out.println("파일입니다.");
		}
		
		String first = fileName.substring(0,fileName.lastIndexOf("."));
		String second = fileName.substring(fileName.lastIndexOf(".")+1);
		
		System.out.println(first);
		System.out.println(second);
		
		
		String html = "안녕하세요\n저는 성영한입니다.\n잘 부탁드립니다.";
		html = html.replaceAll("\n", "<br>");
		
		String url = "http://www.naver.com";
		String path = "/news";
		if(path.startsWith("/news")) {
			System.out.println("뉴스페이지입니다");			
		}else if(path.startsWith("/sprots")) {
			System.out.println("스포츠페이지입니다");			
		}
		
		//trim
		String m1 = "hello";
		String m2 = "hello ";
		String m3 = "hello hi nice";
		
		System.out.println(m3.trim());
		System.out.println(m1.equals(m2.trim()));
		
		//value of
		int a= 10;
		String m4 = String.valueOf(a);
		System.out.println(m4);
		
		char[] c = {'a', 'b', 'c'};
		String m5 = String.valueOf(c, 0, 3);
		System.out.println(m5);
		
		
		//split
		String ssn = "111111-111118";
		String[] strArray = ssn.split("-");
		System.out.println(strArray[0]);
		System.out.println(strArray[1]);
	}
}
