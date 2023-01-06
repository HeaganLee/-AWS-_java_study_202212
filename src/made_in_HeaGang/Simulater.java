package made_in_HeaGang;

import java.util.Scanner;

public class Simulater {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String username = null;
		int total = 100;
		boolean loopFlag1 = true;
		
		System.out.println("========시물레이터에 오신것을 환영합니다=======");
		System.out.print("당신의 이름을 작성하시오: ");
		username = scanner.next();
		
		System.out.println(username + "님 반갑습니다." );
		
		while(loopFlag1) {
			char select = '\0';
			
			System.out.println("=========" + username + "님이 원하시는 인물을 선택하시오");
			System.out.println("1. 박근혜");
			System.out.println("2. 젊은 박근혜");
			System.out.println("나가기는 q를 누르시오");
			
			System.out.print("번호를 선택하시오: ");
			select = scanner.next().charAt(0);
			
			if (select == 'q' || select == 'Q') {
				loopFlag1 = false;
			}else if (select == '1') {
				boolean loopFlag2 = true;
				while(loopFlag2) {
					System.out.println("오신것을 환영합니다.");
					System.out.print("마음에 드시면 1을 아니면 2를 통해 나가주세요: ");
					select = scanner.next().charAt(0);
					if(select == '1') {
						boolean loopFlag3 = true;
						while(loopFlag3) {
							System.out.println("원하는 행동의 번호를 고르시오");
							System.out.println("1. 손을 잡는다.");
							System.out.println("2. 말을 건다.");
							System.out.println("3. 다가간다.");
							System.out.println("나가기 b");
							select = scanner.next().charAt(0);
							
							
							if(select == 'b') {
								System.out.println("어림도 없음");
							}else if(select == '1') {
								System.out.println("태극기 부대가 당신을 죽였습니다.");
								total -= 100;
							}else if(select == '2') {
								System.out.println("당신의 말을 듣고 기절했습니다.");
								total -= 100;
							}else if(select == '3') {
								System.out.println("당신을 보고 놀라 달아났습니다.");
								total -= 100;
							}else {
								System.out.println("잘못 선택");
							}
							if(total <= 0) {
								boolean loopFlag4 = true;
								while(loopFlag4) {
								System.out.println("공략에 실패했습니다.");
								System.out.println("다시하고 싶으면 1 아니면 2");
								select = scanner.next().charAt(0);
								if(select == '1') {
									loopFlag3 = true;
									loopFlag4 = false;
								}else if(select == '2') {
									loopFlag1 = false;
									loopFlag2 = false;
									loopFlag3 = false;
									loopFlag4 = false;
							    }else {
							    	System.out.println("다시입력");
							    }
								}
							}
					}
				}else if(select == '2') {
					loopFlag2 = false;
				}else {
					System.out.println("다시 입력");
				}
			}
		}else {
			System.out.println("다시입력");
		}
	}
System.out.println("수고하셨습니다.");
}
}