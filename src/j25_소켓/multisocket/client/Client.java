package j25_소켓.multisocket.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	
	// 한 콘솔에서 받거나 보내는 것을 계속해서 대기
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 9090);
			
			// 생성된 소켓을 받아주고
			ClientRecive clientRecive = new ClientRecive(socket);
			clientRecive.start();
			
			ClientSend clientSend = new ClientSend(socket);
			clientSend.start();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
