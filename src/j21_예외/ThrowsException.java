package j21_예외;

import java.util.Arrays;
import java.util.List;

public class ThrowsException {
	// RuntimeException은 체크를 하지 않는다.
	// Exception 체크를 한다.
	// throws는 예외를 미룬다. 강제적으로 오류 발생
	// 호출한 지점에서 오류를 처리한다.
	// 단 체크드 exception을 통해서만 가능하다.
	// 언체크드는 try~catch를 해주어야 함, 단 강제성은 못줌
	public static void printList(List<String> list, int size) throws Exception {
		
		for(int i = 0; i < size; i++) {
			System.out.println("[" + i + "]" + list.get(i));
		}
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		String[] name = {"김수현", "이종현", "박성진", "김동민"};
		
		try {
			throw new ClassCastException();
			//printList(Arrays.asList(name), 5);
			
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		} finally { //예외가 터져도 실행이 되고 예외가 안 터져도 실행이 됨 대부분 임시저장 코드를 입력
			System.out.println("무조건 실행");
		}
		
		System.out.println("프로그램 정상종료");
	}

}
