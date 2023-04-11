package silsub3.run;

import silsub3.model.vo.Circle;

public class Run {

	public static void main(String[] args) {
		Circle cir = new Circle();
		
		cir.setRadius(3);
		
		System.out.println("넓이: " + Circle.PI*cir.getRadius()*cir.getRadius());
		System.out.println("둘레" + 2*Circle.PI*cir.getRadius());
		
		
		cir.incrementRadius();
		System.out.println("넓이: " + Circle.PI*cir.getRadius()*cir.getRadius());
		System.out.println("둘레" + 2*Circle.PI*cir.getRadius());

		
		
		
		
	}

}
