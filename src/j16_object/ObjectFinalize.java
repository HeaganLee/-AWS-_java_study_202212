package j16_object;

// public 사용 불가
class Test {
	private int num;

	public Test(int num) {
		super();
		this.num = num;
		System.out.println(num + "생성");
	}
	
	// 생성이 되면 힙메모리를 빌림
	// 어느 변수에다가 참조 시키지 않으면 쓰레기가 됨
	// 가비지 컬랙터가 알아서 치움
	// 사용자가 마음대로 소멸하지 못함
	// finalize는 가비지 컬랙터가 소멸을 했을 때 사용
	// finalize는 실시간에 절대 소멸되지 않게끔 해줄때
	@Override
	protected void finalize() throws Throwable {
		System.out.println(num + "객체 소멸");
	}
	
}

public class ObjectFinalize {
	
	public static void main(String[] args) {
		Test test = null;
		
		// sleep으로 시간을 주면 모두 gc가 일어남
		// 
		for(int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			test = new Test(i);
			
			test = null;
			
			// 가비지 컬랙터를 강제 호출
			// 메모리의 상태를 보고 실행
			System.gc();
		}
		
		
	}

}
