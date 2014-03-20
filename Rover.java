public class Rover 
{
	private int x;
	private int y;
	private int heading;
	private String movement;
	// Need a better way to do this
	private final char headings [] = {'N', 'E', 'S', 'W'};
	// Value to move depends on direction from above array
	private final int step [] = {1, 1, -1, -1};

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
			default: // Generate error event
				System.out.error("Not a valid command");
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
