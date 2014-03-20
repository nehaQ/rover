/* Class Rover is a representation of a rover. At any given time it has a set 
of coordinates (x,y) associated with it along with the direction (NSEW) that 
it is facing. Given a command from the MissionControl class it can either turn 
left(L), turn right (R) or move forward (L). If an errorneous command is given 
an error message is displayed. It also has a method by which its current 
position and heading can be displayed. */

public class Rover 
{
	private int x;
	private int y;
	private int heading;
	private String movement;
	// Need a better way to do this
	private final char headings [] = {'N', 'E', 'S', 'W'};
	// Value to move depends on direction from above array
	private final int stepX [] = {0, 1, 0, -1};
	private final int stepY [] = {1, 0, -1, 0};

	// Constructor to initialise the new object created
	public Rover(int xc, int yc, int h, String m)
	{
		x = xc;
		y = yc;
		heading = h;
		movement = m;
	}

	// Move the rover according to the given condition
	private void moveRover(char move)
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
				// NS direction
				y += stepY[heading];
				x += stepX[heading];
				break;
			}
			default: // Generate error event
				System.err.println("Not a valid command");
		}
	}

	public void roverMoves()
	{
		for(char move : movement.toCharArray())
			moveRover(move);
	}
	
	public void display()
	{
		System.out.println(x+" "+y+" "+headings[heading]);
	}
}
