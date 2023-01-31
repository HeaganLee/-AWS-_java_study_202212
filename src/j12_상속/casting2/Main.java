package j12_상속.casting2;

public class Main {
	
	public static void main(String[] args) {
		Taxi taxi = new Taxi();
		Subway subway = new Subway();
		
		// 택시가 없기에 택시의 형태로 변할 수가 없다.
		Transpotation transpotation = new Transpotation();
//		Taxi t1 = (Taxi) transpotation; // 다운캐스팅
//		
//		// transportaion1을 서브웨이로 변화를 할 수 없다.
//		// 왜냐하면 transportaion1에는 서브웨이 데이터가 없기 때문이다.
//		// 본 형태로 돌아갈 때만 다운 캐스팅이 가능하다.
//		Transpotation transportation1 = taxi;
//		Subway s1 = (Subway) transpotation1;
		
		
//		Transpotation transportation2 = subway;
		
		Transpotation[] transpotations = new Transpotation[6];
		
		transpotations[0] = taxi;
		transpotations[1] = subway;
		transpotations[2] = taxi;
		transpotations[3] = subway;
		transpotations[4] = taxi;
		transpotations[5] = subway;
		
		for (int i = 0; i < transpotations.length; i++) {
			// 
			if(transpotations[i] instanceof Taxi) {
				Taxi tx = (Taxi) transpotations[i];
				tx.checkTaxiNumber();
				
			}else if(transpotations[i] instanceof Subway) {
				Subway sw = (Subway) transpotations[i];
				sw.checkRoute();
				
			}
			
			
			
			transpotations[i].go();
		}
		
		for(Transpotation t : transpotations) {
			t.stop();
		}
		
    }
	
}