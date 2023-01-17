package j21_예외;

// 자바는 컴파일러 언어 전부해석 후 출력 예외처리를 하지 않더라도 실행 가능
// python는 한줄한줄 출력
// runtime exception의 하위 이며는 unchecked 그 외에는 checked
public class ArrayException {
	
	public static void main(String[] args) {
		
       
			
		try {
			
			 Integer[] nums = {1, 2, 3, 4, 5};
				for(int i = 0; i < 6; i++) {
				System.out.println(nums[i]);
				}
            // 타고 내려와야 한다.
			// 인덱스를 넘었을 때
		} catch (IndexOutOfBoundsException e) {
			System.out.println("예외 처리");
			// 주소가 null일 때
		}catch (NullPointerException e) {
			System.out.println("예외 처리함");
		}catch (Exception e) {
			System.out.println("예상 못한 예외 처리함");
		}
		
		System.out.println("프로그램 정상 종료");
	}

}
