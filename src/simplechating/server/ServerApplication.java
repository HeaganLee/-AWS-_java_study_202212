package simplechating.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketOption;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
class ConnectedSocket extends Thread {
	private static List<ConnectedSocket> socketList = new ArrayList<>();
	private Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	
	private String username;
	
	public ConnectedSocket(Socket socket) {
		this.socket = socket;
		socketList.add(this);
	}
	
	@Override
	public void run() {
		try {
			outputStream =  socket.getOutputStream();
			PrintWriter out = new PrintWriter(outputStream, true);
			out.println("join");
			
			inputStream = socket.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			
			// 클라이언트가 던져준 접속메세지를 받는다.
			username = in.readLine();
			System.out.print(username + "님이 접속하였습니다.");
			
			String userListStr = "";
			
			for(int i = 0; i < socketList.size(); i++) {
				userListStr += socketList.get(i).getUsername();
				if(i < socketList.size() - 1) {
					userListStr += ",";
				}
			}
			
			for(ConnectedSocket connectedSocket : socketList) {
				outputStream = connectedSocket.getSocket().getOutputStream();
				out = new PrintWriter(outputStream, true);
				out.println("@welcome/" + username + "님이 접속하였습니다.");
				out.println("@userList/" + userListStr);
			}
			
			while(true) {
				String message = in.readLine();
				for(ConnectedSocket connectedSocket : socketList) {
					outputStream = connectedSocket.getSocket().getOutputStream();
					out = new PrintWriter(outputStream, true);
					out.println(message);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

public class ServerApplication {
	
	public static void main(String[] args) {
		// serversocket 생성
		ServerSocket serverSocket = null;
		try {
			// 포트번호를 9090으로 설정
			serverSocket = new ServerSocket(9090);
			System.out.println("=====<<< 서버 실행 >>>=====");
			
			while(true) {
				Socket socket = serverSocket.accept(); // 클라이언트의 접속을 기다림
				ConnectedSocket connectedSocket = new ConnectedSocket(socket);
				connectedSocket.start();
					
			}
				
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			if(serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("=====<<< 서버 종료 >>>=====");
		}
		
	}

}
