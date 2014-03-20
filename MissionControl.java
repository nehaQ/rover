import java.util.Scanner; // Scanner makes it easier to parse strings

class Rover 
{

	int x;
	int y;
	int heading;
}

public class MissionControl
{
	// A 2d array the size of the plateau. Can be used to hold position of 
	// rovers, obstacles etc. So maneavouring is easier.
	String plateau [][]; 
	char headings [] = {'N', 'E', 'S', 'W'};
	
	public static void main(String[] args)
	{
		// Scan the first line separately as its format is different.
		Scanner parser =  new Scanner (args[0]);
		// Initialise the size of the plateau
		plateau = new String[parser.nextInt()][parser.nextInt()];
		parser.close();

		for (String input : args)
		{
			Scanner parser = new Scanner(input);

			parser.close(); 
		}	
	}
}