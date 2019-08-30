package java_20190808.file.server;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class FileServerThread implements Runnable{
	private Socket socket;
	public FileServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		InputStream in = null;
		OutputStream out = null;
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {
			in = socket.getInputStream();
			isr = new InputStreamReader(in);
			br = new BufferedReader(isr);
			String fileName = br.readLine();
			System.out.println("요청받은 파일 :" +fileName);
			fis = new FileInputStream("c:\\dev\\test"+fileName);
			
			out = socket.getOutputStream();
			byte[] readByte = new byte[1024*8];
			int readByteCount = 0;
			
			while ( (readByteCount = fis.read(readByte)) != -1) {
				out.write(readByte,0,readByteCount);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(in!=null)in.close();
				if(out!=null)out.close();
				if(fis!=null)fis.close();
				if(isr!=null)isr.close();
				if(br!=null)br.close();
				if(socket!=null)socket.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}	
	
}
