package j07_반복;

public class Star {

	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}// 1번 1~10개 까지의 별
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}// 2번 10~1개 까지의 별
		System.out.println();
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 9 - i; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k < i + 1; k++) {
				System.out.print("*");
			}
				System.out.println();
		}// 3번 오른쪽 변 직각 삼각
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k < 10 - i; k++) {
				System.out.print("*");
			}
				System.out.println();
		}// 4번 3번 반대
		System.out.println();
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10 - i - 1; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i * 2 + 1; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}// 5번 이등변 삼각형
		
		for (int i = 0; i < 10; i++) {
			if (i < 6) {
			for (int j = 0; j < 10 - i - 1; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i * 2 + 1; j++) {
				System.out.print("*");
			}
			}
			else {
				for (int j = 0; j < i - 1; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < i * 2 + 1; j++) {
					System.out.print("*");
				}
				
			}
			System.out.println();
		}// 6번 다이아 몬드
	}
}
