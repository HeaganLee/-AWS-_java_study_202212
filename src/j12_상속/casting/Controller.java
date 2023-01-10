package j12_상속.casting;

import java.util.Scanner;

public class Controller {

	private View view;
	private Scanner scanner;
	
	// View는 MainView이다.
	// View는 UpdateView가 포함 되기도 한다.
	public Controller(View view) {
		this.view = view;
		scanner = new Scanner(System.in);
	}
	
	public void run() {
		boolean flag = true;
		String select = null;
		
		while(flag) {
			view.show();
			System.out.print("명령 입력: ");
			select = scanner.nextLine();
			flag = view.menu(select);
			System.out.println();
			
		}
		
	}
}
