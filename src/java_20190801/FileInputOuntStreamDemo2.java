package java_20190801;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOuntStreamDemo2 {
	public static void main(String[] args) {
		FileInputStream fis = null;  //"C:\\dev\\test\\jdk.exe"
		FileOutputStream fos = null; //"C:\\dev\\test\\2019\\jdk.exe"
		
		try {
			
			fis = new FileInputStream("C:\\dev\\test\\jdk.exe");
			fos = new FileOutputStream("C:\\dev\\test\\2019\\jdk.exe");
			
			byte[] bf = new byte[1024];
			int count ;
			
			while((count = fis.read(bf))!=-1)
			{
				fos.write(bf,0,count);
			}
			System.out.println("성공~");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null) fis.close();
				if(fos != null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
	}
}



/* 연습용
fis = new FileInputStream("C:\\dev\\test\\jdk.exe");
fos = new FileOutputStream("C:\\dev\\test\\2019\\jdk.exe");
int readByteCount = 0;
byte[] b = new byte[1024*10];
//fis.read(b) => FileInputStream에 1024 바이트를 읽어서
//b에 저장하고 읽은 바이트 수를 반환한다.
long start = System.currentTimeMillis();
while((readByteCount = fis.read(b)) != -1) {
	fos.write(b,0,readByteCount);
}
long end = System.currentTimeMillis();
System.out.println("경과시간 : " + (end-start));
*/