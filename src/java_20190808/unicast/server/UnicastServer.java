package java_20190808.unicast.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UnicastServer {
	private int port;
	
	public UnicastServer(int port) {
		this.port = port;
	}
	
	private void run() {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UnicastServerThread ust = null;
		
		while(true) {
			
			System.out.println("대기중");
			try {
				Socket socket = serverSocket.accept();
				String ip = socket.getInetAddress().getHostAddress();
				System.out.println(ip + "와 연결");
				
				ust = new UnicastServerThread(socket);
				Thread t = new Thread(ust);
				t.start();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		new UnicastServer(5000).run();
	}


	
}
