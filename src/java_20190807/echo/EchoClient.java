package java_20190807.echo;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
	private String ip;
	private int port;

	public EchoClient(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	public void run() {
		Socket socket = null;
		OutputStream os = null;
		OutputStreamWriter osr = null;
		BufferedWriter bw = null;

		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			// 포인트
			socket = new Socket(ip, port);

			os = socket.getOutputStream();
			osr = new OutputStreamWriter(os);
			bw = new BufferedWriter(osr);

			bw.write("???");
			bw.newLine();
			bw.flush();

			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);

			String readLine = br.readLine();
			System.out.println(readLine);

		} catch (UnknownHostException e) {
			System.out.println("서버주소가 잘못되었습니다.");
		} catch (IOException e) {
			System.out.println("서버주소가 열리지 않았습니다.");
		}

	}

	public static void main(String[] args) {
		new EchoClient("192.168.0.83", 3000).run();
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