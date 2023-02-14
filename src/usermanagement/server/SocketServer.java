package usermanagement.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import usermanagement.dto.RequestDto;
import usermanagement.dto.ResponseDto;
import usermanagement.entity.User;
import usermanagement.server.controller.AccountController;

public class SocketServer extends Thread {
	// static으로 설정이 되었기에 클라이언트가 생성된 만큼 리스트에 넣어진다.
	private static List<SocketServer> socketServerList = new ArrayList<>();
	
	private Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	private Gson gson;
	
	public SocketServer(Socket socket) {
		this.socket = socket;
		gson = new Gson();
		// 담당자를 배정
		socketServerList.add(this);
	}
	
	@Override
	public void run() {
		try {
			reciveRequest();
			
		} catch (IOException e) {
			System.out.println(socket.getInetAddress() + ":" + socket.getPort() + "클라이언트 접속이 끊어졌습니다.");
		}
	}
	
	private void reciveRequest() throws IOException {
		inputStream = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		
		while(true) {
			// 현재 request에 들어오는 것은 json 형태이다.
			String request = reader.readLine();
			// 클라이언트로 부터 받은 데이터를 읽었을 때 null일 경우 멈춤
			if(request == null) {
				throw new ConnectException();				
			}
			// null이 아니면 실행
			RequestMapping(request);
			
		}
	}
	
	private void RequestMapping(String request) throws IOException {
		RequestDto<?> requestDto = gson.fromJson(request, RequestDto.class);
		String resoursce = requestDto.getResource();
		// 메세지를 보낼건지 받을건지 확인
		switch (resoursce) {
			case "register" :
			ResponseDto<?> responseDto = 
				AccountController.getInstance().register((String)requestDto.getBody());
			sendResponse(responseDto);
			break;
		default:
			System.out.println("해당 요청은 처리할 수 없습니다.(404)");
			break;
		}
	}
	
	private void sendResponse(ResponseDto<?> responseDto) throws IOException {
		String response = gson.toJson(responseDto);
		outputStream = socket.getOutputStream();
		PrintWriter writer = new PrintWriter(outputStream, true);
		writer.println(response);
		writer.flush();
	}
}
