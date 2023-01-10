package j12_상속.casting;

public class Main {
	
	public static void main(String[] args) {
		
		// 컨트롤러 변수 생성
		// MainView()를 메게변수로
		Controller controller = new Controller(new MainView());
		controller.run();
		
		System.out.println("프로그램 종료");
		
	}

}
