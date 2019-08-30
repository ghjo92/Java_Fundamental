package java_20190802;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedInputOutputStreamDemo {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {

//			1. 1바이트씩 읽고 출력. 시간 7초. 
//			fis = new FileInputStream("C:\\dev\\test\\java-pdf.zip");
//			fos = new FileOutputStream("C:\\dev\\test\\java-pdf-copy.zip");
//
//			int readbyte = 0;
//			long start = System.currentTimeMillis();
//			while ((readbyte = fis.read()) != -1) {
//				fos.write(readbyte);
//			}
//			long end = System.currentTimeMillis();
//			System.out.println((end - start));

//			2. BufferedInputStream 이용. 1바이트 읽고 버퍼에 담아서 출력. 경과시간 0.031초
//			fis = new FileInputStream("C:\\dev\\test\\java-pdf.zip");
//			fos = new FileOutputStream("C:\\dev\\test\\java-pdf-copy.zip");
//			bis = new BufferedInputStream(fis);
//			bos = new BufferedOutputStream(fos);
//
//			int readbyte = 0;
//			long start = System.currentTimeMillis();
//			while ((readbyte = bis.read()) != -1) {
//				bos.write(readbyte);
//			}
//			bos.flush();
//			long end = System.currentTimeMillis();
//			System.out.println((end - start));
			
			
//			3. InputStream, OutputStream을 8192 바이트씩 이용하여 출력. 경과시간 0.001초
			fis = new FileInputStream("C:\\dev\\test\\java-pdf.zip");
			fos = new FileOutputStream("C:\\dev\\test\\java-pdf-copy.zip");

			int readbyte = 0;
			byte[] bf = new byte[8192];
			long start = System.currentTimeMillis();
			while ((readbyte = fis.read(bf)) != -1) {
				fos.write(bf,0,readbyte);
			}
			long end = System.currentTimeMillis();
			System.out.println((end - start));
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
