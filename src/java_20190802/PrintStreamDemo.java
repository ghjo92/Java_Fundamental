package java_20190802;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamDemo {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		PrintStream ps = null;
		
		
		try {
			
			//ps = System.out; //모니터
			//ps.println("Hello World");
			
			fis = new FileInputStream("C:\\dev\\test\\java-pdf.zip");
			fos = new FileOutputStream("C:\\dev\\test\\java-pdf-copy.zip");
			
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			ps = new PrintStream(bos,true);//auto flush
			
			
			int readbyte = 0;
			while((readbyte = bis.read())!= -1)
			{
				ps.write(readbyte);
			}			
			//bos.flush();
			
		} catch (IOException e) {
			e.printStackTrace();			
		}finally {		
				try {
					if(fis!=null)fis.close();
					if(fos!=null)fos.close();
					if(bis!=null)bis.close();
					//if(bos!=null)bos.close();
				} catch (IOException e) {				
					e.printStackTrace();
				}
		}
		
		
		
	}
}
