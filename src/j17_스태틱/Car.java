package j17_스태틱;


import java.time.LocalDateTime;

public class Car {
	
	private static final int NOW_YEAR = LocalDateTime.now().getYear();
	
	private static final String CODE = "KIA-" + NOW_YEAR + "-";
	private static int ai = 1;
	
	private String serialCode; //KIA-20230-00
	private String modelName;
	private int size = 4;
	
	public Car(String modelName) {
		this.modelName = modelName;
		
		// 0을 4개를 채우겠다.
		serialCode = CODE + String.format("%04d", ai);
		ai++;
	}

	@Override
	public String toString() {
		return "Car [serialCode=" + serialCode + ", modelName=" + modelName + "]";
	}
	
	
	

}
