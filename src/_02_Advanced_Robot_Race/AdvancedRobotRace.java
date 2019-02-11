package _02_Advanced_Robot_Race;

import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	
	// Re-do the robot race recipe from level 3 module 0.
	// This time, use threads to make all of the robots go at the same time.
	public static void main(String[] args) {
		Robot[] bots = new Robot[5];

		for (int i = 0; i < 5; i++) {
			bots[i] = new Robot();
			bots[i].setX(200 * (i + 1));
			bots[i].setY(900);
			bots[i].setSpeed(10);
		}
		Random r = new Random();

		Thread t0 = new Thread(() -> {
			while (true)
				bots[0].move(r.nextInt(50));
		});

		Thread t1 = new Thread(() -> {
			while (true)
				bots[1].move(r.nextInt(50));
		});

		Thread t2 = new Thread(() -> {
			while (true)
				bots[2].move(r.nextInt(50));
		});

		Thread t3 = new Thread(() -> {
			while (true)
				bots[3].move(r.nextInt(50));
		});

		Thread t4 = new Thread(() -> {
			while (true)
				bots[4].move(r.nextInt(50));
		});
		
		t0.start();
		t1.start();
		t2.start();
		t3.start();
		t4.start();

		boolean winner = false;
		int winBot = -1;
		while (!winner) {
			for (int i = 0; i < 5; i++) {
				if (bots[i].getY() < 100) {
					winner = true;
					winBot = i;
					try {
						t0.join();
						t1.join();
						t2.join();
						t3.join();
						t4.join();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		bots[winBot].sparkle();
		bots[winBot].turn(360);
		JOptionPane.showMessageDialog(null, "Robot " + winBot + " wins!!!");
	}
}
