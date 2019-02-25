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
			bots[i].setSpeed(5);
		}
		Random r = new Random();

		Thread t0 = new Thread(() -> {
			while (getWinner(bots) == -1)
				bots[0].move(r.nextInt(50));
			if (getWinner(bots) == 0)
				win(bots[0], 1);
		});

		Thread t1 = new Thread(() -> {
			while (getWinner(bots) == -1)
				bots[1].move(r.nextInt(50));
			if (getWinner(bots) == 1)
				win(bots[1], 2);
		});

		Thread t2 = new Thread(() -> {
			while (getWinner(bots) == -1)
				bots[2].move(r.nextInt(50));
			if (getWinner(bots) == 2)
				win(bots[2], 3);
		});

		Thread t3 = new Thread(() -> {
			while (getWinner(bots) == -1)
				bots[3].move(r.nextInt(50));
			if (getWinner(bots) == 3)
				win(bots[3], 4);
		});

		Thread t4 = new Thread(() -> {
			while (getWinner(bots) == -1)
				bots[4].move(r.nextInt(50));
			if (getWinner(bots) == 4)
				win(bots[4], 5);
		});

		t0.start();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

	public static int getWinner(Robot[] bots) {
		for (int i = 0; i < bots.length; i++) {
			if (bots[i].getY() < 200)
				return i;
		}
		return -1;
	}

	public static void win(Robot bot, int num) {
		bot.sparkle();
		bot.setSpeed(10);
		bot.turn(360);
		JOptionPane.showMessageDialog(null, "Robot " + num + " wins!!!");
		System.exit(0);
	}
}
