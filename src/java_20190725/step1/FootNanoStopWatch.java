package java_20190725.step1;

//1. �䱸���׹и� ������� ��� �ð��� ������ּ���.
public class FootNanoStopWatch {
	
	long startTime;
	long endTime;
	long startNanoTime;
	long endNanoTime;
	
	public double getElapsedTime() {
		return (double)(endTime - startTime)/(double)1000;
	}
	
	public double getElapsedNanoTime() {
		return (double)(endNanoTime - startNanoTime)/(double)1000000000;
	}
	
	public static void main(String[] args) {
		FootNanoStopWatch f1 = new FootNanoStopWatch();
		//currentTimeMillis() => 1970�� 1�� 1�Ϻ��� ���ݱ����� �ð��� �и�������� ��ȯ�Ѵ�.
		f1.startNanoTime = System.nanoTime();
		
		for(long i=0; i<10_000_000_000l;i++) {
			
		}
		
		f1.endNanoTime = System.nanoTime();
		double elapsedTime = f1.getElapsedNanoTime();
		
		System.out.printf("����� �ð� : %.9f", elapsedTime);
	}
}
