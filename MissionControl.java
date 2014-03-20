import java.util.Scanner; // Scanner makes it easier to parse strings

class Rover 
{

	int x;
	int y;
	int heading;
	String movement;

	public Rover(int xc, int yc, int h, String m)
	{
		x = xc;
		y = yc;
		heading = h;
		movement = m;
	}
}

public class MissionControl
{
	// A 2d array the size of the plateau. Can be used to hold position of 
	// rovers, obstacles etc. So maneavouring is easier.
	String plateau [][]; 
	// Need a better way to do this
	char headings [] = {'N', 'E', 'S', 'W'};
	// Array of rovers
	Rover roversOnMars;

	// Here the assumption is that letters will always be entered in uppercase
	private int findDirection(char compass)
	{
		if(compass == 'N')
			return 0;
		else if(compass == 'E')
			return 1;
		else if(compass == 'S')
			return 2;
		else 
			return 3;
	}

	public static void main(String[] args)
	{
		// Scan the first line separately as its format is different.
		Scanner parser =  new Scanner (args[0]);
		// Initialise the size of the plateau
		plateau = new String[parser.nextInt()][parser.nextInt()];
		parser.close();

		// Initialise rover array
		roversOnMars = new Rover[(args.length - 1)/2];

		String input;
		int x_coor, y_coor, heading;
		String movement;
		for (int index = 1; index<args.length; index=index+2)
		{
			input = args[index];
			Scanner parser = new Scanner(input);
			x_coor = parser.nextInt();
			y_coor = parser.nextInt();
			heading = findDirection(parser.nextChar());
			parser.close();
			// Get movement
			movement = args[++index];
		}	
	}
}