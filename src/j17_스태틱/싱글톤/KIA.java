package j17_스태틱.싱글톤;

public class KIA {
	
	private static KIA instance = null;
	
	// 싱글톤은 하나만 있어야 하기에 
	// private로 생성하여 된다.
	// 하지만 static이기에 객체를 생성을 하지도 않더라고 다 가지고 올 수 있다.
	// 이걸 왜 쓰는가? 하나만 존재를 해야되는 상황이 발생을 하게 된다.
	// 만약 여러개로 만들어 진다면
	// 계속해서 확인을 해야 되기 때문이다.
	private KIA() {}
	
	// 한번 생성을 하면 다시 생성 되지 않는다.
	// 한번 리턴을 해주면 다른 곳에서도 계속 생성이 된다.
	public static KIA getIntance() {
		if(instance == null) {
			instance = new KIA();
		}
		return instance;
		
	}
	
	public void printCompayName() {
		System.out.println(getClass().getSimpleName());
	}

}
