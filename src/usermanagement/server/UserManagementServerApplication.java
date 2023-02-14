package usermanagement.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class UserManagementServerApplication implements Runnable {

	private final static int PORT = 9090;
	private ServerSocket serverSocket;
	
	@Override
	public void run() {
		try {
			// 서버를 열림
			serverSocket = new ServerSocket(PORT);
			System.out.println("=========<< 서버실행 >>========");
			
			
			socketConnection();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			try {
				// serverSocket이 null인지 확인 필요함 null일 경우 서버가 열러있지 않기 때문이다.
				if(serverSocket != null) {
					serverSocket.close();
				}
				System.out.println("========<< 서버종료 >>========");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private void socketConnection() throws IOException {
		while(true) {
			// 클라이언트 연결을 기다림
			Socket socket = serverSocket.accept();
			// 방금 접속한 클라이언트를 보낸다.
			SocketServer socketServer = new SocketServer(socket);
			// start를 했다는 의미는 스레드를 했다
			socketServer.start();
		}
	}
	
	public static void main(String[] args) {
		UserManagementServerApplication application = new UserManagementServerApplication();
		application.run();
	}
}
