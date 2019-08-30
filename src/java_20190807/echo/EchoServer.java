package java_20190807.echo;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class EchoServer {
	private int port;
	
	public EchoServer(int port) {
		this.port = port;
	}
	
	public void run() {
		ServerSocket serverSocket = null;
		try {
			//포인트********************
			serverSocket = new ServerSocket(port);		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true) {
			System.out.println("클라이언트의 접속을 기다리고있습니다.");
			try {
				//포인트*********************
				Socket socket = serverSocket.accept();
				
				InetAddress inet = socket.getInetAddress();	
				String ip = inet.getHostAddress();
				System.out.println("클라이언트가 접속했습니다. IP :" +ip);
				
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				
				String readLine = br.readLine();
				
				System.out.println(readLine);
				
				OutputStream os = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				BufferedWriter bw = new BufferedWriter(osw);
				
				bw.write(readLine);
				bw.newLine();
				bw.flush();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	
	
	public static void main(String[] args) {
		new EchoServer(3000).run();
	}
	
	
}
//private int port;
//public EchoServer(int port) {
//	this.port = port;
//}
//public void run() {
//	ServerSocket serverSocket = null;
//	try {
//		//1. 서버소켓 생성
//		serverSocket = new ServerSocket(port);
//	} catch (IOException e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//	}
//	
//	while(true) {
//		System.out.println("클라이언트의 접속을 기다리고있습니다.");
//		
//		try {
//			//2.서버소켓 대기
//			Socket socket = serverSocket.accept();
//			//5.클라이언트와 통신할수있는 소켓을 생성한다.
//			InetAddress i = socket.getInetAddress();
//			String ip = i.getHostAddress();
//			System.out.println("클라이언트가 접속했습니다. IP :" +ip);
//			
//			//7.통신
//			InputStream in = socket.getInputStream();
//			InputStreamReader isr = new InputStreamReader(in);
//			BufferedReader br = new BufferedReader(isr);
//			String readLine = br.readLine();
//			System.out.println(readLine);
//			
//			//8. 클라이언트에게 메세지를 다시보냄 echo
//			OutputStream out = socket.getOutputStream();
//			OutputStreamWriter osr = new OutputStreamWriter(out);
//			BufferedWriter bw = new BufferedWriter(osr);
//			
//			bw.write(readLine);
//			bw.newLine();
//			bw.flush();
//			
//			
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}
//
//public static void main(String[] args) {
//	new EchoServer(3000).run();
//}