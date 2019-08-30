package java_20190808.file.client;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class FileClient {
	private String ip;
	private int port;
	private String fileName;

	public FileClient(String ip, int port, String fileName) {
		this.ip = ip;
		this.port = port;
		this.fileName = fileName;
	}

	public void run() {
		Socket socket = null;
		OutputStream os = null;
		OutputStreamWriter osr = null;
		BufferedWriter bw = null;
		FileOutputStream fos = null;		
		InputStream is = null;
		
		
		try {
			// 포인트			
			socket = new Socket(ip, port);
			System.out.println("연결중");		
			
			os = socket.getOutputStream();
			osr = new OutputStreamWriter(os);
			bw = new BufferedWriter(osr);

			bw.write(fileName);
			bw.newLine();
			bw.flush();

			is = socket.getInputStream();
			File f= new File("c:\\dev\\test\\network");
			f.mkdirs();
			f = new File(f, fileName);
			fos = new FileOutputStream(f);
			byte[] readBytes = new byte[1024*8];
			int readByteCount = 0;
			while((readByteCount = is.read(readBytes)) != -1) {
				fos.write(readBytes,0,readByteCount);
				System.out.println("전송중");
			}
					
			
			System.out.println("완료");		
		
		} catch (UnknownHostException e) {
			System.out.println("서버주소가 잘못되었습니다.");
		} catch (IOException e) {
			System.out.println("서버주소가 열리지 않았습니다.");
		}finally {
			try {
				if(socket !=null) socket.close();
				if(os !=null) os.close();
				if(osr !=null) osr.close();
				if(is !=null) is.close();
				if(fos !=null) fos.close();
			
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		

	}
	
	public static void main(String[] args) {
		new FileClient("192.168.0.52", 4000, "java-13.pdf").run();
	}

}
//private String ip;
//private int port;
//public EchoClient(String ip, int port) {
//	this.ip = ip;
//	this.port = port;
//}
//
//public void run() {
//	Socket socket = null;
//	
//	
//	
//	try {
//		//3,4 서버와 연결
//		socket = new Socket(ip, port);
//		//6 통신 
//		OutputStream out = socket.getOutputStream();
//		OutputStreamWriter osw = new OutputStreamWriter(out);
//		BufferedWriter bw = new BufferedWriter(osw);
//		bw.write("↓바보");
//		bw.newLine();
//		bw.flush();
//		
//		//9 서버에서  echo 받기
//		InputStream in = socket.getInputStream();
//		InputStreamReader isr = new InputStreamReader(in);
//		BufferedReader br = new BufferedReader(isr);
//		
//		String readLine = br.readLine();
//		System.out.println(readLine);
//		
//		
//		
//		//System.out.println("접속되었습니다.");
//	} catch (UnknownHostException e) {
//		System.out.println("서버주소가 잘못되었습니다.");
//	} catch (IOException e) {
//		System.out.println("서버가 열리지 않았습니다.");
//	}
//			
//}
//
//public static void main(String[] args) {
//	//127.0.0.1
//	//192.168.0.52
//	new EchoClient("192.168.0.52", 3000).run();
//}