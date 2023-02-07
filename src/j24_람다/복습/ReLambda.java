package j24_람다.복습;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

public class ReLambda {

	public static void main(String[] args) {
		
		//1. Runnable - run()
		Runnable a = () -> System.out.println("하나만실행");
		Runnable b = () -> {
			System.out.println("여");
			System.out.println("러");
			System.out.println("명");
			System.out.println("령");
			System.out.println("실");
			System.out.println("행");
			
		};
		
		a.run();
		b.run();
		
		// 2. Supplier - T get();
		Supplier<LocalDate> c = () -> LocalDate.now();
		
		Supplier<String> d = () -> {
			LocalDate now = LocalDate.now();
			return now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
		};
	}
}
