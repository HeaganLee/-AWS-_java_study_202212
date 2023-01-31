package test_practice;

public class Cyliner {
	
	public int getVolume(int radius, int height) {
		int circle;
		
		circle = (radius * radius) * height;
		//System.out.println(circle);
		return circle;
		
	}
	
	public static void main(String[] args) {
		
		Circle c = new Circle(3 ,4);
		Cyliner cy = new Cyliner();
		
		System.out.println(cy.getVolume(c.getRadius(), c.getHeight()));
		
	}

}
