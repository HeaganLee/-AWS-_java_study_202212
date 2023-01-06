package j12_배열;

import java.util.Scanner;

public class J12_UserService {
	
	// 항생 생성자에 대입을 하기 위해
	// 미리 선언
	// 전역변수를 사용하는 이유는 
	private Scanner scanner;
	
    public J12_UserService() {
    	// 결합도가 높은 코드
    	scanner = new Scanner(System.in);
    }
	
    // run()은 무한 반복을 통해 메인메뉴를 보여주는 생성자이다.
    public void run() {
    	
    	// Flag를 지역을 주는 이유는 전체로 잡으면 전체적으로 영향이 감
    	boolean loopFlag = true;
    	char select = '\0';
    	
    	// 메인메뉴를 보여 주기 위한 무한반복문이다.
    	while(loopFlag) {
    		// showMainMenu()생성자는 메인메뉴에서 보여지는
    		// 메뉴들을 출력을 한다.
    		showMainMenu();
    		// inputSelect()생성자는 사용자가 입력한 값을 리턴 받는다.
    		// 그 후 select에 넣는다.
    		select = inputSelect("메인");
    		// mainMenu()생성자는 select의 값을 이용하여 처리를 한다.
    		// select 값이 q or Q면 loopFla에 false가 입력
    		// 계속해서 loopFlag에 True 값이 입력이 되어 반복됨 
    		loopFlag = mainMenu(select);
    	}
    	
    }
    
    public void stop() {
    	for(int i = 0; i < 10; i++) {
    		try {
				Thread.sleep(500);
				System.out.println("프로그램 종료중....(" + (i + 1) + "/10)");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    	System.out.println("프로그램 종료");
    }
	
	public char inputSelect(String menuName) {
		System.out.print(menuName + "메뉴선택: ");
		// scanner로 문자 받고
		char select = scanner.next().charAt(0);
		// 버퍼를 없애주기 위해 nextLine으로 없애기
		scanner.nextLine();
		return select;
	}
	
	public void showMainMenu() {
		System.out.println("=========<<메인메뉴>>========");
		System.out.println("1. 사용자 전체 조회");
		System.out.println("2. 사용자 등록");
		System.out.println("3. 사용자이름으로 회원 조회");
		System.out.println("4. 회원 정보 수정");
		System.out.println("=============================");
		System.out.println("q. 프로그램 종료");
		System.out.println();
	}
	
	private boolean mainMenu(char select) {
		boolean flag = true;
		
		if(isExit(select)) {
			flag = false;
		}else {
			if(select == '1') {
				
			}else if(select == '2') {
				
			}else if(select == '3') {
				
			}else if(select == '4') {
				
			}else {
				System.out.println(getSelectedErrorMessage());
				
			}
			
		}
		System.out.println();
		
		// flag 값을 리턴 시켜서 loopFlag에 대입
		return flag;
	}
	
	// 필요없는 변수를 선호 할 필요 없이 return으로 바로 받는 것
	private boolean isExit(char select) {
		return select == 'q' || select == 'Q';
	}
	
	// 나중에 수정이 가능함
	// void로 사용하면 추후에 수정이 불가
	private String getSelectedErrorMessage() {
		return "###<< 잘못된 입력입니다. 다시 입력하세요 >>###";
	}
	
}
