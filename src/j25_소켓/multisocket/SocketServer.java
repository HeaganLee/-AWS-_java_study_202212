package j25_소켓.multisocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketServer extends Thread {
	
	public static List<SocketServer> clientList = new ArrayList<>();
	private Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	
	private static int autoIncrement = 1;
	private String name;
	
	public SocketServer(Socket socket) {
		this.socket = socket;
		// 유저가 들어올떄 마다 autoIncrement 증가
		name = "user" + autoIncrement++;
		// clientList에는 소켓이 들어온다.
		clientList.add(this);
	}
	
	@Override
	public void run() {
		System.out.println("[연결된 클라이언트 정보]");
		System.out.println("IP: " + socket.getInetAddress());
		
		try {
			inputStream = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			
			sendToAll(name + "님이 접속하였습니다.");
			
			outputStream = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(outputStream, true);
			
			writer.println(name + "님이 접속하였습니다.");
			
			while(true) {
				// 메세지가 들어올때 까지 기다림(담당자가 대기하고 있다)
				String message = reader.readLine();
				// 메세지가 null인지 체크
				// null이 들어왔다는 것은 통신이 끊겼다.
				if(message == null) {
					break;
				}
				sendToAll(message);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				outputStream.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	// 메세지를 받고 소켓서버하나는 clientList에서 꺼낸다.
	// 클라이언트에게 output를 지시
	// 메세지를 서버에 접속을 하고있는 모든 사용자들에게 보냄
	private void sendToAll(String message) throws IOException {
		for(SocketServer socketServer : clientList) {
			outputStream = socketServer.socket.getOutputStream();
			PrintWriter writer = new PrintWriter(outputStream, true);
			writer.println(name + ": " + message);
			
		}
	}
	
}
