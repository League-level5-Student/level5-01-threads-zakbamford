package _01_Olympic_Rings;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One
	// robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String[] args) {
		Robot blue, black, red, yellow, green;

		blue = new Robot(600, 400);
		black = new Robot(1000, 400);
		red = new Robot(1400, 400);
		yellow = new Robot(800, 800);
		green = new Robot(1200, 800);
		
		Thread t1 = new Thread(() -> blue.move(1));
		Thread t2 = new Thread(() -> blue.move(1));
		Thread t3 = new Thread(() -> blue.move(1));
		Thread t4 = new Thread(() -> blue.move(1));
		Thread t5 = new Thread(() -> blue.move(1));

		for (int i = 0; i < 360; i++) {
			blue.move(1);
			black.move(1);
			red.move(1);
			yellow.move(1);
			green.move(1);
			
			blue.turn(1);
			black.turn(1);
			red.turn(1);
			yellow.turn(1);
			green.turn(1);
		}
	}
}
