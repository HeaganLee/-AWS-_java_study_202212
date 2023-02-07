package j25_소켓;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketServer {

	public static final int PORT = 9090;
	
	public static void main(String[] args) {
		List<Socket> clients = new ArrayList<>();
		
	/*
	 * 클라이언트 소켓을 통해 서버를 접속을 할 때 ip주소와 포트번호가 있어야 한다.
	 * 서버가 실행이 되면 포트와 ip가 생긴다. 포트번호는 지정을 해주어야 한다.
	 * 클라이언트가 서버에 접속시 소켓을 통해 접속을 하려면 서버의 포트번호와 ip주소를 알아야 한다.
	 * 접속을 기다리면서 요청을 같이 받기 위해 스레드가 필요하다.
	 * 클라이언트 끼리 주고 받을 때 binary와 text로 주고 받는다.
	 * 만약 다른 클라이언트에게 보낼때 json으로 보내는 것이 좋습니다.
	 * 	
	 */
		// 포트가 정해져 있다.
		// 포트번호로 서버를 열었다.
	
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			// 서버는 종료될 때 까지 종료가 되어서는 안 된다.
			while(true) {
				System.out.println("클라이언트의 접속을 기다리는 중입니다.");
				// 클라이언트가 접속을 받으면 넘어감
				// socket 하나가 클라이언트 하나이다.
				// socket지역변수이기에 while 중에 생성 소멸을 반복
				Socket socket = serverSocket.accept();
				clients.add(socket);
				System.out.println("클라이언트가 연결되었습니다.");
				System.out.println(clients);
				// socket에게 아웃풋을 해준다.
				OutputStream outputStream = socket.getOutputStream();
				// PrintWriter를 통해 클라이언트에게 보냄
				PrintWriter out = new PrintWriter(outputStream, true);
				out.println("___서버에 접속한 것을 환영합니다.");
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	
	}
	
}
