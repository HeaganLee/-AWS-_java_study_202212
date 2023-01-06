package j07_반복;

import java.util.Scanner;

public class Menu {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int total = 0;
		
		boolean loopFlag1 = true;
		
		while(loopFlag1) {
			char select = '\0';
			
			System.out.println("========<<식당>>========");
			System.out.println("1. 김밥천국");
			System.out.println("2. 탄탄면");
			System.out.println("3. 홍대개미");
			System.out.println("4. 밥앤밥");
			System.out.println("========================");
			System.out.println("q. 프로그램 종료");
			System.out.println("========================");
			
			System.out.print("식당 선택: ");
			select = scanner.next().charAt(0);// 
			
			if (select == 'q' || select == '0') {
				loopFlag1 = false;
			}else if (select == '1') {
				boolean loopFlag2 = true;
				
				while(loopFlag2) {
					
					System.out.println();
					System.out.println("========<<김밥 천국>>========");
					System.out.println("1. 라면: 4000");
					System.out.println("2. 돌솥비빔밥: 5000");
					System.out.println("3. 오므라이스: 4000");
					System.out.println("4. 김치볶음밥: 6000");
					System.out.println("========================");
					System.out.println("q. 프로그램 종료");
					System.out.println("b. 뒤로가기");
					System.out.println("========================");
				
					System.out.print("메뉴 번호 선택: ");
					select = scanner.next().charAt(0);//
					
					if(select == 'b') {
						loopFlag2 = false;
						
					}else if(select == 'q' || select == 'Q') {
						loopFlag1 = false;
						loopFlag2 = false;
					}else if (select == '1') {
						System.out.println("라면을 선택했습니다.");
					}else if (select == '2') {
						System.out.println("돌솥비빔밥을 선택했습니다.");
					}else if (select == '3') {
						System.out.println("오므라이스를 선택했습니다.");
					}else if (select == '4' ) {
						System.out.println("김치볶음밥음밥을 선택했습니다.");
					}
					else {
						System.out.println();
						System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX");
						System.out.println("사용할 수 없는 번호입니다.");
						System.out.println("다시 입력하세요");
						System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX");
						
					}
					System.out.println();
				}
				
			}else if (select == '2') {
				boolean loopFlag2 = true;
				
				while (loopFlag2) {
					System.out.println();
					System.out.println("========<<탄탄면>>========");
					System.out.println("1. 마라탕: 7000");
					System.out.println("2. 고기 탄탄면: 7000");
					System.out.println("3. 해물 탄탄면: 7000");
					System.out.println("4. 차돌 탄탄면: 7000");
					System.out.println("========================");
					System.out.println("q. 프로그램 종료");
					System.out.println("b. 뒤로가기");
					System.out.println("========================");
				
					System.out.print("메뉴 번호 선택: ");
					select = scanner.next().charAt(0);//
					
					if (select == 'b') {
						loopFlag2 = false;
					}else if (select == 'q' || select == 'Q') {
						loopFlag2 = false;
						loopFlag1 = false;
					}else if (select == '1') {
						System.out.println("마라탕을 선택하였습니다.");
					}else if (select == '2') {
						System.out.println("고기 탄탄면 선택");
					}else if (select == '3' ) {
						System.out.println("해물 탄탄면 선택");
					}else if (select == '4') {
						System.out.println("차돌 탄탄면 선택");
					}else {
						System.out.println();
						System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX");
						System.out.println("사용할 수 없는 번호입니다.");
						System.out.println("다시 입력하세요");
						System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX");
						
					}
					System.out.println();
				}
			
			}else if (select == '3') {
				boolean loopFlag2 = true;
				
				while (loopFlag2) {
					System.out.println();
					System.out.println("========<<홍대개미>>========");
					System.out.println("1. 스테이크 덮밥: 11000");
					System.out.println("2. 참치 덮밥: 12000");
					System.out.println("3. 연어 덮밥: 10000");
					System.out.println("4. 간장새우 덮밥: 12000");
					System.out.println("========================");
					System.out.println("q. 프로그램 종료");
					System.out.println("b. 뒤로가기");
					System.out.println("========================");
					
					System.out.print("번호선택: ");
					select = scanner.next().charAt(0);
					
					if (select == 'b') {
						loopFlag2 = false;
					}else if (select == 'q' || select == 'Q') {
						loopFlag2 = false;
						loopFlag1 = false;
					}else if (select == '1') {
						System.out.println("스테이크 덮밥 선택");
					}else if (select == '2') {
						System.out.println("참치 덮밥 선택");
					}else if (select == '3') {
						System.out.println("연어 덮밥 선택");
					}else if (select == '4') {
						System.out.println("간장새우 덮밥 선택");
					}else {
						System.out.println();
						System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX");
						System.out.println("사용할 수 없는 번호입니다.");
						System.out.println("다시 입력하세요");
						System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX");
						
					}
					System.out.println();
				}
				
			}else if (select == '4') {
				boolean loopFlag2 = false;
				
				while(loopFlag2) {
					System.out.println();
					System.out.println("========<<밥앤밥>>========");
					System.out.println("1. 소고기 전골: 15000");
					System.out.println("2. 김치찌개: 7000");
					System.out.println("3. 소머리국밥: 8000");
					System.out.println("4. 된장찌개: 7000");
					System.out.println("========================");
					System.out.println("q. 프로그램 종료");
					System.out.println("b. 뒤로가기");
					System.out.println("========================");
					
					System.out.print("번호선택: ");
					select = scanner.next().charAt(0);
					
					if(select == 'b') {
						loopFlag2 = false;
						
					}else if(select == 'q' || select == 'Q') {
						loopFlag1 = false;
						loopFlag2 = false;
					}else if (select == '1') {
						System.out.println("소고기 전골을 선택했습니다.");
					}else if (select == '2') {
						System.out.println("김치찌개을 선택했습니다.");
					}else if (select == '3') {
						System.out.println("소머리국밥를 선택했습니다.");
					}else if (select == '4' ) {
						System.out.println("된장찌개을 선택했습니다.");
					}
					else {
						System.out.println();
						System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX");
						System.out.println("사용할 수 없는 번호입니다.");
						System.out.println("다시 입력하세요");
						System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX");
						
					}
					System.out.println();
					
				}
				
			}else {
				System.out.println();
				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX");
				System.out.println("사용할 수 없는 번호입니다.");
				System.out.println("다시 입력하세요");
				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			}
			
			System.out.println();
			
		}
		
		System.out.println("프로그램 정상 종료!");
		System.out.println(total);
		
	}

}
