package j18_제네릭;

public class Main2 {
	/*
	 * ? 와일드카드 제약
	 * extends 대상 객체 하위
	 * super 대상 객체 상위 
	 */
	
	
	// ? 와일드카드라고 지칭
	// 어떠한 형태로는 사용을 할 수 있기 떄문
	// Object도 사용이 가능하다
	// 모든 것을 가지고 있기에 형변환이 자유자재로 가능하다.
	public CMRespDto<?> response(CMRespDto<?> cmRespDto){
		
		System.out.println("[응답데이터]");
		System.out.println(cmRespDto);
		return cmRespDto;
		
	}
	// main 객체가 생성이 되어야 하지만 사용이 가능하다.
	// static은 생성을 하지 않아도 사용이 가능하다.
	// 그렇기에 사용이 될려면 객체를 생성이 되어야 한다.
	public static void main(String[] args) {
		Main2 main = new Main2();
		
		CMRespDto<String> hello 
			= new CMRespDto<String>(200, "성공", "안녕하세요");
		
		CMRespDto<Integer> score 
			= new CMRespDto<Integer>(200, "성공", 85);
		
		System.out.println("hello");
		System.out.println(main.response(hello));
		
		System.out.println("score");
		System.out.println(main.response(score));
		
		// 안녕하세요.
	}

}
