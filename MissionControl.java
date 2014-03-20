/* Class MissionControl reads the commands given from the user and interprets
 them to drive the rover which is represented as an object of the Rover class */

import java.util.Scanner; // Scanner makes it easier to parse strings
import java.lang.Object;

public class MissionControl
{
	// Here the assumption is that letters will always be entered in uppercase
	private static int findDirection(String compass)
	{
		if(compass.equals("N"))
			return 0;
		else if(compass.equals("E"))
			return 1;
		else if(compass.equals("S"))
			return 2;
		else 
			return 3;
	}

	public static void main(String[] args) 
	{
		// Scan the first line separately as its format is different.
		Scanner parse =  new Scanner (args[0]);
		
		// A 2d array the size of the plateau. Can be used to hold position of 
		// rovers, obstacles etc. So maneavouring is easier. We don't need this
		// for the current list of operations - so it will be unused for the
		// time being
		String plateau [][] = new String[parse.nextInt()][parse.nextInt()];
		parse.close();

		// Array of rovers
		Rover roversOnMars[] = new Rover[(args.length - 1)/2];

		String input;
		int x_coor, y_coor, heading;
		String movement;
		for (int index = 1; index<args.length; index++)
		{
			input = args[index];
			Scanner parser = new Scanner(input);
			x_coor = parser.nextInt();
			y_coor = parser.nextInt();
			heading = findDirection(parser.next());
			parser.close();
			movement = args[++index];
			// Create new object and add it to the rover array
			roversOnMars[(index/2) - 1] = new Rover(x_coor, y_coor, heading, movement);
		}

		// Start simulating robot movement
		for(Rover current : roversOnMars)
		{
			current.roverMoves();
			// Display its final position
			current.display();
		}	
	}
}