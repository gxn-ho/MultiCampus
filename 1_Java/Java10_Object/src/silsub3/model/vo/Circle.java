package silsub3.model.vo;

public class Circle {
	public static final double PI = 3.14;
	private static int radius;
	
	public Circle() {}
	
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		Circle.radius = radius;
	}
	
	public void incrementRadius() {
		Circle.radius++;
	}
	
}
