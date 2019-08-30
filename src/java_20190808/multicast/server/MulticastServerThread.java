package java_20190808.multicast.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class MulticastServerThread implements Runnable {

	private Socket socket;
	private ArrayList<MulticastServerThread> list;
	private BufferedWriter bw;
	private boolean isStop;

	public MulticastServerThread(Socket socket, ArrayList<MulticastServerThread> list) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
		this.list = list;
		this.isStop = false;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		BufferedWriter bw = null;
		BufferedReader br = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			while (isStop == false) {
				String readLine = br.readLine();
				System.out.println(readLine);
				if (readLine.equals("shutdown")) {
					isStop = true;
					bw.write(readLine + "\n");
					bw.flush();
				} else {
					broadCast(readLine + "\n");
				}
			}
			list.remove(this);
		} catch (IOException e) {
			System.out.println("비정상종료");
			list.remove(this);
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
	// end run

	public void broadCast(String msg) throws IOException {
		for (MulticastServerThread mst : list) {
			mst.sendMessage(msg);
		}
	}

	private void sendMessage(String msg) throws IOException {
		bw.write(msg);
		bw.flush();
	}

}
