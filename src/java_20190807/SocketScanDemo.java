package java_20190807;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketScanDemo {
	public static void main(String[] args){
		//InetAddress i1 = InetAddress.getByName("99flower.co.kr");
		Socket socket = null;
		for(int i=1; i<1024;i++) {			
	
				try {
					socket = new Socket("211.119.250.80",i);
					System.out.println(i+"번 포트는 사용하고 있습니다.");
				} catch (UnknownHostException e) {
					System.out.println("호스트가 존재하지 않습니다.");
				} catch (IOException e) {
					System.out.println(i+"번 포트는 사용하고 있지않습니다.");
				}
		}
		
		socket = socket = new Socket("211.119.250.80",80);
		OutputStream out = socket.getOutputStream();
		out.write(b);
		
		
	}
}
