package java_20190801;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStreamDemo {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("C:\\dev\\test\\son.jpg");
			File file = new File("C:\\dev\\test\\test1");
			if(!file.isDirectory())
				file.mkdirs();			
			fos = new FileOutputStream("C:\\dev\\test\\test1\\son1.jpg");
			int readByte = 0;
			while((readByte = fis.read()) != -1) {
				fos.write(readByte);
			}					
			System.out.println("\n성공");
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(fis != null)
					fis.close();
				if(fos != null)
					fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}	
}
