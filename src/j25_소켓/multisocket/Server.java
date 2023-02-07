package j25_소켓.multisocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static final int PORT = 9090;
	
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			System.out.println("서버를 실행합니다.");
			
			// 클라이언트의 접속을 받는 무한반복문
			while(true) {
				// 클라이언트 접속을 기다림
				Socket socket = serverSocket.accept();
				// 소켓 생성과 동시에 스레드 생성
				SocketServer socketServer = new SocketServer(socket);
				// 스레드 실행
				socketServer.start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("서버를 종료합니다.");
		}
	}
}
