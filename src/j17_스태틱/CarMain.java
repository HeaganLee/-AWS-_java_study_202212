package j17_스태틱;

public class CarMain {

	
	public static void main(String[] args) {
		
		Car[] car = new Car[5];
		
		car[0] = new Car("스타렉스");
		car[1] = new Car("스타리아");
		car[2] = new Car("그렌져");
		car[3] = new Car("아반떼");
		car[4] = new Car("벨라투스");
		
		for(Car c : car) {
			System.out.println(c);
		}
	}
}
