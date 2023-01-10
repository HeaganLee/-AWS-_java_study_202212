package j13_상속;

public class ExtendsMain {

	public static void main(String[] args) {
		
		KiaCar kiaCar = new KiaCar();
		
		kiaCar.setPrice(30000000);
		
		// 호출 순서는 부모 -> 자식
		System.out.println(kiaCar);
		
		System.out.println(kiaCar.getPrice());
		// 부모요소가 가지고 있는 메소드와
		// 자식요소가 가지고 있는 메소는 다르다
		// ** 주소가 다름 **
		System.out.println(kiaCar.discountPrice(20));
		
		
	}
}
