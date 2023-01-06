package j12_배열;

import java.util.Random;

public class Array3 {

	public static void main(String[] args) {
		
		int[] numes = new int[10];
		
		
		Random random = new Random();
		
		// 
		for (int i = 0; i < numes.length; i++) {
			numes[i] = i;
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println(numes[i]);
		}
		
//		System.out.println();
//		for (int i = 0; i < numes2.length; i++) {
//			numes2[i] = random.nextInt(numes2.length);
//			
//			if (i > 0) {
//				int j = 0;
//				while (j < i) {
//					if(numes2[i] != numes2[i-j]) {
//						break;
//					}else {
//						numes2[i] = random.nextInt(numes2.length);
//					}
//					
//					j++;
//				}
//			}
//			
//		}
//		
//		for (int i = 0; i < numes2.length; i++) {
//			System.out.println(numes2[i]);
//		}
		System.out.println();
		
		int[] numes2 = new int[10];// 10개의 공간 생성
		
		for (int i = 0; i < numes2.length; i++) {// 10개의 공간에 숫자를 넣기 위해
			while(true) { // 중복인지 아닌지 확인 
				boolean findFlag = true;
				
				int randomNum = random.nextInt(45) + 1; // 랜덤한 값을 변수에 넣음
				// 비교하기 위해
				
				for(int j = 0; j < numes2.length; j++) {// 0에서 부터 9까지 반복을 돌림
					// 똑같은 것이 있는지 확인을 해준다
					if(numes2[j] == randomNum) {// 만약 randomNum과 numes2[j]가 있다면 멈추고 다시 랜덤한 값을 받음
						findFlag = false;// 순차 탐색
						break; // 
					}
				}
				
				if(findFlag) {// 만약 똑같은 값이 없다면 findFlag가 true가 되며 현재 numes2의 값에 넣어줌
					numes2[i] = randomNum;
					break; // while를 멈춰주는 break, 중복이 없다는 것을 확인 했을 때
					
				}
			}
		}
		
		for (int i = 0; i < numes2.length; i++) {
			System.out.println(numes2[i]);
		}
		
		
		
		
		
	}

}
