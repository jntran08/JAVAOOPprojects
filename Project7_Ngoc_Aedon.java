import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Project7_Ngoc_Aedon 
{

	/** Play a slot machine. The user is initially given 20 tokens and will see three
	 * numbers.  If all three numbers match and are 7s, the user will win 750 points. If 
	 * all three numbers match but are not 7s, the user will win 75 points. If two numbers
	 * are 7s, the user will get 20 points, if two numbers match and are not seven, the user
	 * will win 5 points.  If no numbers match the user loses.
	 * @param args  There are no command line arguments.
	 * 
	 * @author Deborah A. Trytten
	 */
	public static void main(String[] args) 
	{
		Scanner  input = new Scanner(System.in);
		final int INITIAL_TOKENS = 20;
		
		int[] digits;
		int userTokens = INITIAL_TOKENS;
		String response= "Yes";
		
		while (userTokens > 0 && response.equalsIgnoreCase("yes"))
		{
			// spin the wheel
			System.out.println("You have " + userTokens +" tokens.");
			// Call generateRandom Digits and show contents to user
			digits = generateRandomDigits(1,10,3);
			System.out.print("Your spin was ");
			for(int i = 0; i<3;++i) {
				System.out.print(digits[i] + " ");
			}
			System.out.println();
			
			// Call calculateWin
			
			int result = calculateWin(digits); // this will hold the number of points won or lost
			
			System.out.println("You earned " + result + " points.");
			userTokens = userTokens + result;
			System.out.println("You now  have " + userTokens + " tokens.");
			
			if (userTokens != 0)
			{
				System.out.println("Would you like to play again? Yes/No");
				response = input.nextLine();
			}

		}
		
		input.close();
	}

	/** Create an array that contains size random digits, each between low
	 * and high (inclusive).
	 * 
	 * @param low  The smallest random int that will be generated (inclusive)
	 * @param high The largest random int that will be generated (inclusive)
	 * @param size The number of random int values to be generated in the array
	 * @return A newly constructed array containing size random digits between
	 * low and high (inclusive)
	 */
	public static int[] generateRandomDigits(int low, int high, int size)
	{
		int[] array = new int[size];
		for(int i = 0; i<size;++i) {
			array[i] = findRandom(low,high);
		}
		return array; 
	}
	/** Find a random int uniformly distributed between low and high (inclusive).
	 * @param low The lower bound for the random number (inclusive)
	 * @param high The upper bound for the random number (inclusive)
	 * @return A random int uniformly distributed between low and high (inclusive).
	 */
	public static int findRandom(int low, int high)
	{
		int num = (int) (Math.random() * (high-low+1)) + low;
		return num;  
	}
	
	/** Determine how many points the user won. The result of logic are in the
	 * class preamble.
	 * @param x The digit on the first wheel.
	 * @param y The digit on the second wheel.
	 * @param z The digit on the third wheel.
	 * @return The score for this round.
	 */
	// This method uses pass by sharing
	public static int calculateWin(int[] digits)
	{
		int pointChange = 0;
		if(digits[0] == digits[1] && digits[1] == digits[2]) {
			if(digits[0] == 7) {
				pointChange = 500;
			}
			else {
				pointChange = 50;
			}
		}
		else if (digits[0] == digits[1] || digits [1] == digits[2] || digits[2] == digits[0]) {
			if(digits[0] == 7 || digits[1] == 7) {
				pointChange = 15;
			}
			else {
				pointChange = 3;
			}
		}
		else {
			pointChange = -1;
		}
		return pointChange; 
	}
}
