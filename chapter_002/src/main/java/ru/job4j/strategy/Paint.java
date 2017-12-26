package ru.job4j.strategy;

/**
 * Class Paint служит для прорисовки квадрата и треугольника в псевдографике.
 * @author Shaev Andrey.
 * @version 1.01.
 * @since 22.12.2012
*/
public class Paint {
	
	public static void main(String[] args) {
		Paint paint = new Paint();
		paint.draw(new Square());
		paint.draw(new Triangle());
	}
	
	public void draw(Shape shape) {
		System.out.print(shape.draw());
	}	
}
