package made_in_HeaGang;

import java.util.Random;

public class Loddo {

	public static void main(String[] args) {
		
		// 랜덤 값을 넣어주기 위해 Random 호출
		Random random = new Random();
		// 7개의 공간이 들어가는 배열 만들기
		int [] loddo = new int[7];
		
		// 총 random 배열의 길이 만큼 돌아가도록 for 문 돌림
		for (int i = 0; i < loddo.length; i++) {
			
			// while문 무한 반복을 통해 중복확인
			while(true) {
				boolean loopFlag = true;
				
				int randomNum = 0;
				randomNum = random.nextInt(37) + 1;
				
				// 만약 중복되는 값이 있다면 다시 랜덤 값을 할당 받음
				for (int j = 0; j < loddo.length; j++) {
					
					if (loddo[j] == randomNum) {
						loopFlag = false;
						break;
						
					}
						
				}
				// 만약 중복되는 값이 하나도 없다면 할당받은 랜덤값을 해당 순차 공간에 삽입
				if (loopFlag) {
					loddo[i] = randomNum;
					break;
					
				}
				
				

			}
		}
		
		for (int i = 0; i < loddo.length; i++) {
			System.out.println(loddo[i]);
		}
	}
}
