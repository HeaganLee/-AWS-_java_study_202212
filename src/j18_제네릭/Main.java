package j18_제네릭;

public class Main {
	
	
	public static void main(String[] args) {
		TestData<String, Integer> td = new TestData<String, Integer>("김준일", 30);
		TestData<String, Double> td2 = new TestData<String, Double>("junil", 100.05);
		System.out.println(td);
		System.out.println(td2);
		
		CMRespDto<TestData<String, Integer>> cm =
				new CMRespDto<TestData<String, Integer>>(200, "성공", td);
		
		// ? 어떤 데이터가 들어오는지 모를때 사용
		// 이것은 들어온 데이터를 확인하고 타고타고 올라가 데이터 타입을 확인한다.
		CMRespDto<?> cm1 =
				new CMRespDto<>(200, "성공", td);
		
		
		
		System.out.println(cm);
	}

}
