package j25_소켓;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.google.gson.Gson;

import usermanagement.dto.RequestDto;

public class SocketClient {
	
	public static void main(String[] args) {
	
		
		try {
			Socket socket = new Socket("127.0.0.1", 9090);
			System.out.println("서버에 접속에 성공!!");
			
			// 서버에서 주는 메세지를 Input을 통해 받는다.
			// 받기위해서는 buffer를 써야한다.
			// 사용하는 이유는 buffer는 한꺼번에 읽을 수 있을 수 있기 때문이다.
			InputStream inputStream = socket.getInputStream();
			InputStreamReader streamReader = new InputStreamReader(inputStream);
			BufferedReader reader = new BufferedReader(streamReader);
			
			//System.out.println(reader.readLine());
			
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter printWriter = new PrintWriter(outputStream, true);
			
			Gson gson = new Gson();
			RequestDto<String> dto = new RequestDto<String>("test", "테스트 데이터");
			
			printWriter.println(gson.toJson(dto));
			
			
			//  DNS(ip 주소를 사용자가 있을 수 있는 도메인 주소로 바뀌게 해주는 것) 확인 오류
		} catch (UnknownHostException e) {
			e.printStackTrace();
			// 통신이 끊기면 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
