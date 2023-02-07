package j25_소켓.multisocket;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketServer extends Thread {
	
	public static List<Socket> clientList = new ArrayList<>();
	private static Socket socket;
	
	public SocketServer(Socket socket) {
		this.socket = socket;
		clientList.add(socket);
	}
	
	@Override
	public void run() {
		
	}
	
}
