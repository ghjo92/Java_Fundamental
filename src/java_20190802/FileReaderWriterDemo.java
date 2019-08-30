package java_20190802;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterDemo {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			fr = new FileReader("c:\\dev\\test\\kic.txt");
			fw = new FileWriter("c:\\dev\\test\\kic-copy.txt");
			
			
			int readCount = 0;
			char[] readChars = new char[10];			
			int readChar = 0;
			while((readChar = fr.read(readChars)) != -1) {
				System.out.println(new String(readChars,0,readChar));
				fw.write(new String(readChars,0,readChar));
				//System.out.print((char)readChar);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fr!=null) fr.close();
				if(fw!=null) fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
