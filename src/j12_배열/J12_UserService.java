package j12_배열;

import java.util.Scanner;

public class J12_UserService {
	
	// 항생 생성자에 대입을 하기 위해
	// 미리 선언
	// 전역변수를 사용하는 이유는 
	private Scanner scanner;
	private J12_UserRepository userRepository;
	
	// 결합도를 낮추기위해 매개변수를 이용
	// repository가 service에 의존하고 있다. 즉 repository가 의존성이다.
	// 의존성을 해주어야 확장성이 생긴다.
	
    public J12_UserService(J12_UserRepository userRepository) {
    	// 결합도가 높은 코드
    	scanner = new Scanner(System.in);
    	// usertable를 불러오기위해
    	this.userRepository = userRepository;
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
	
	private void showUsers() {
		J12_User[] users = userRepository.getUserTable();
		
		System.out.println("=======<< 회원 전체 조회 >> ========");
		
		// user 객체의 주소를 꺼냄
		// 참조를 통해 실행이 가능
		for(J12_User user : users) {
			System.out.println(user.toString());
		}
		
		System.out.println("===================================");
	}
	
	
	private void registerUser() {
		J12_User user = new J12_User();
		
		System.out.println("=======<< 회원 등록 >> ========");
		System.out.print("사용자이름: ");
		// set을 통해 바로 입력을 받음
		user.setUsername(scanner.nextLine());
		
		System.out.print("비밀번호: ");
		user.setPassword(scanner.nextLine());
		
		System.out.print("성명: ");
		user.setName(scanner.nextLine());
		
		System.out.print("이메일: ");
		user.setEmail(scanner.nextLine());
		
		userRepository.saveUser(user);
	}
	
	private void findUser() {
		
		boolean loop = true;
		while(loop) {
		String username;
		
		System.out.println("=======<< 해당 사용자 조회 >> ========");
		
		J12_User user = new J12_User();
		System.out.print("사용자 입력: ");
		username = scanner.nextLine();
		user = userRepository.findUsername(username);
	
		loop = false;
		if (user == null) {
			System.out.println("없는 사용자 입니다. 다시 입력하세요.");
			loop = true;
		} else {
			System.out.println(user);
		}
		}
		}
	
	private void modyfyUser() {
		
		boolean loop = true;
		while(loop) {
			
		
		String username;
		char select = '\0';
		String pw = null;
		
		J12_User user = new J12_User();
		System.out.print("사용자 입력: ");
		username = scanner.nextLine();
		user = userRepository.findUsername(username);
		
		if (user == null) {
			System.out.println("해당 사용자이름은 존재하지 않는 사용자이름입니다.");
			loop = true;
		}else {
			loop = false;
			boolean loop2 = true;
			while(loop2) {
				
				editMenu(username);
				select = scanner.next().charAt(0);
				
				if(select == 'b' || select == 'B') {
					loop2 = false;
				}else if(select == '1') {
					
					System.out.println("========<< 비밀번호 변경 >>========");
					System.out.print("기존의 비밀번호를 입력하시오: ");
					pw = scanner.nextLine();
					J12_User password = userRepository.findUserpw(pw);
					if (password == null) {
						System.out.println("비밀번호가 일치하지 않습니다.");
					}else {
						String a = null;
						String b = null;
						System.out.print("새로운 비밀번호 입력: ");
						a = scanner.nextLine();
						System.out.print("새로운 비밀번호 확인: ");
						b = scanner.nextLine();
						
						if(a == b) {
							
						}
						
					}
					
				}
			}
			
		}
		
		}
		
	}
	
	private boolean mainMenu(char select) {
		boolean flag = true;
		
		// isExit가 true가 아니면 else로 실행
		if(isExit(select)) {
			flag = false;
			
		}else {
			if(select == '1') {
				showUsers();
				
			}else if(select == '2') {
				registerUser();
			}else if(select == '3') {
				findUser();
			}else if(select == '4') {
				
			}else {
				System.out.println(getSelectedErrorMessage());
				
			}
			
		}
		// 줄바꿈
		System.out.println();
		
		// flag 값을 리턴 시켜서 loopFlag에 대입
		return flag;
	}
	
	// 수정메뉴
	public void editMenu(String username) {
		System.out.println("========<< 수정메뉴 >>========");
		System.out.println("사용자이름은: " + username);
		System.out.println("==============================");
		System.out.println("1. 비밀번호 변경");
		System.out.println("2. 이름 변경");
		System.out.println("3. 이메일 변경");
		System.out.println("==============================");
		System.out.println("b. 뒤로가기");
		System.out.println();	
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
