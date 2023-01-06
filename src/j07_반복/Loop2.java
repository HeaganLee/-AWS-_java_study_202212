package j07_반복;

public class Loop2 {

	public static void main(String[] args) {
		
		int total = 0;
		
		for (int i = 0/* 변수와 초기화*/ ; i < 100/* 조건문(조건이 참이어야지 가능) */; i++/* 조건변화 수식*/) {
			
			
			total += i + 1; 
			// 지역 변수의 기준은 중괄호
			// 전역 변수의 지역 기준으로 바깥의 모두
			// 전역에서 변수로 지정되어 있으면 지역 내에서는 사용 불가
			// 단 순서를 바꾸면 가능
			// 컴퓨터는 0부터 시작
			// 몇번을 반복하는 반복문인지 파악한다.
		}
		System.out.println("총합은 " + total);
	}
}
