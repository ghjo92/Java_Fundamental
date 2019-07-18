package java_20190716;

public class OperatorDemo {
	public static void main(String args[]) {
		double a = 10;
		int b = 20;
		double c = a+b;
		System.out.println(c);
		
		int d = 22;
		double e = d / a;
		System.out.println(e);
		d++;
		System.out.println(d);
		for(int i=0; i<10; i++)
			d++;
		System.out.println(d);
		
		boolean isa = false;
		boolean isb = false;
		byte ba =0x40;
		int bb = ba<<1;
		System.out.println(bb);
		System.out.println(1+2+3+"4"+(5+6) );
	}
}
