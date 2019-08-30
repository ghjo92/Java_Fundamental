package java_20190808.unicast.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class UnicastServerThread implements Runnable {

	private Socket socket;
	private boolean isStop;
	
	public UnicastServerThread(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
		this.isStop = false;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		BufferedWriter bw = null;
		BufferedReader br = null;
		try {
			bw = new BufferedWriter (new OutputStreamWriter(socket.getOutputStream()));
			br = new BufferedReader (new InputStreamReader(socket.getInputStream()));
			
			
			while(isStop==false) {
				String readLine = br.readLine();
				System.out.println(readLine);
				/*
				if(readLine != null) {
					bw.write(readLine);
					bw.newLine();
					bw.flush();	
				}*/
				if(readLine.equals("shutdown")) {
					isStop = true;
					bw.write(readLine+"\n");
					bw.flush();
				}else
				{
					bw.write(readLine);
					bw.newLine();
					bw.flush();
				}				
				/*
				else {
					isStop= true;
				}*/				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
				try {
					if(bw!=null)bw.close();
					if(br!=null)br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
	}


}
