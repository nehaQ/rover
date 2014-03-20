import java.util.Scanner; // Scanner makes it easier to parse strings
import java.lang.Object;

class Rover 
{
	private int x;
	private int y;
	private int heading;
	private String movement;
	// Need a better way to do this
	private char headings [] = {'N', 'E', 'S', 'W'};
	private int step [] = {1, 1, -1, -1};// Value to move depends on direction

	// Constructor to initialise the new object created
	public Rover(int xc, int yc, int h, String m)
	{
		x = xc;
		y = yc;
		heading = h;
		movement = m;
	}

	// Move the rover according to the given condition
	public void moveRover(char move)
	{
		switch (move) 
		{
			case 'L': 
			{
				heading--;
				heading = (heading + 4)%4;
				break;
			}
			case 'R':
			{
				heading++;
				heading = (heading + 4)%4;
				break;
			}
			case 'M':
			{
				if(heading%2 == 0) // NS direction
					y += step[heading];
				else			  // EW direction
					x+= step[heading];
				break;
			}
			default: // Do nothing
		}
	}

	public String getMovement()
	{
		return movement;
	}
	
	public void display()
	{
		System.out.println(x+" "+y+" "+headings[heading]);
	}
}

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
			movement = current.getMovement();
			for (char move : movement.toCharArray())
			{
				current.moveRover(move);
			}
			// Display its final position
			current.display();
		}	
	}
}