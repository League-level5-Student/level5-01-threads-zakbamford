package _02_Advanced_Robot_Race;

import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class RobotRace {
	
	// 1. make a main method
	public static void main(String[] args) {

		// 2. create an array of 5 robots.
		Robot[] bots = new Robot[5];
		int[] degTurned = new int[5];

		// 3. use a for loop to initialize the robots.
		for (int i = 0; i < 5; i++) {
			bots[i] = new Robot();
			degTurned[i] = 0;
		}

		// 4. make each robot start at the bottom of the screen, side by side, facing up
		for (int i = 0; i < 5; i++) {
			bots[i].setX(400);
			bots[i].setY(500);
			bots[i].setSpeed(10);
		}

		// 5. use another for loop to iterate through the array and make each robot move
		// a random amount less than 50.
		Random r = new Random();

		// 6. use a while loop to repeat step 5 until a robot has reached the top of the
		// screen.
		boolean winner = false;
		int winBot = -1;
		int rnd = 0;
		while (!winner) {
			for (int i = 0; i < 5; i++) {
				rnd = r.nextInt(10);
				bots[i].move(rnd * 8);
				bots[i].turn(rnd);
				degTurned[i] += rnd;
				if (degTurned[i] >= 360) {
					winner = true;
					winBot = i;
				}
			}
		}

		// 7. declare that robot the winner and throw it a party!
		bots[winBot].sparkle();
		bots[winBot].turn(360);
		JOptionPane.showMessageDialog(null, "Robot " + winBot + " wins!!!");

		// 8. try different races with different amounts of robots.

		// 9. make the robots race around a circular track.

	}
}