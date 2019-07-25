package java_20190725.step1;

//1. �䱸���׹и� ������� ��� �ð��� ������ּ���.
public class FootStopWatch {
	
	long startTime;
	long endTime;
	
	public double getElapsedTime() {
		return (double)(endTime - startTime)/(double)1000;
	}
	
	
	public static void main(String[] args) {
		FootStopWatch f1 = new FootStopWatch();
		//currentTimeMillis() => 1970�� 1�� 1�Ϻ��� ���ݱ����� �ð��� �и�������� ��ȯ�Ѵ�.
		f1.startTime = System.currentTimeMillis();
		
		for(long i=0; i<10_000_000_000l;i++) {
			
		}
		
		f1.endTime = System.currentTimeMillis();
		double elapsedTime = f1.getElapsedTime();
		
		System.out.printf("����� �ð� : %.3f", elapsedTime);
	}
}
