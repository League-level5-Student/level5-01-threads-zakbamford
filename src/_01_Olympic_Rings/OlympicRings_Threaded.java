package _01_Olympic_Rings;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One
	// robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String[] args) {
		Robot blue, black, red, yellow, green;

		blue = new Robot(200, 300);
		black = new Robot(600, 300);
		red = new Robot(1000, 300);
		yellow = new Robot(400, 700);
		green = new Robot(800, 700);
		
		blue.setSpeed(10);
		black.setSpeed(10);
		red.setSpeed(10);
		yellow.setSpeed(10);
		green.setSpeed(10);
		
		blue.setPenColor(Color.BLUE);
		black.setPenColor(Color.BLACK);
		red.setPenColor(Color.RED);
		yellow.setPenColor(Color.YELLOW);
		green.setPenColor(Color.GREEN);
		
		blue.penDown();
		black.penDown();
		red.penDown();
		yellow.penDown();
		green.penDown();

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 360; i++) {
				blue.move(5);
				blue.turn(1);
			}
		});
		
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 360; i++) {
				black.move(5);
				black.turn(1);
			}
		});
		
		Thread t3 = new Thread(() -> {
			for (int i = 0; i < 360; i++) {
				red.move(5);
				red.turn(1);
			}
		});
		
		Thread t4 = new Thread(() -> {
			for (int i = 0; i < 360; i++) {
				yellow.move(5);
				yellow.turn(1);
			}
		});
		
		Thread t5 = new Thread(() -> {
			for (int i = 0; i < 360; i++) {
				green.move(5);
				green.turn(1);
			}
		});

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

	}
}
