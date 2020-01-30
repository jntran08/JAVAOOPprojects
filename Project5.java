import  java.util.Scanner;
public class Project5
{

	public static void main (String[] args)
	{
		int timesEnteredData = 0;
		final int SENTINEL = -1;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the polling data or "+ SENTINEL + " to stop.");
		int value1 = input.nextInt();
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		int count5 = 0;
		int duplicate = 0;
		int positive = 0;
		int negative = 0;
		int value2 = 3;
		while (value1 >-1 && value2 >-1)
		{
			if (value1==1)
			{
				count1+=1;
			}
			else if(value1 ==2)
			{
				count2+=1;
			}
			else if(value1==3)
			{
				count3+=1;
			}
			else if(value1==4)
			{
				count4+=1;
			}
			else if(value1==5)
			{
				count5+=1;
			}
			System.out.println("Enter the polling data or "+ SENTINEL + " to stop.");
			value2=input.nextInt();
			if (value1 >-1 && value2 >-1)
			{
			if (value2 > value1)
			{
				positive++;
			}
			else if (value2 < value1)
			{
				negative++;
			}
			else if(value2==value1)
			{
				duplicate++;
			}
			}
			value1=value2;
		}
		System.out.println("1 was chosen "+ count1+" times");
		System.out.println("2 was chosen "+ count2+" times");
		System.out.println("3 was chosen "+ count3+" times");
		System.out.println("4 was chosen "+ count4+" times");
		System.out.println("5 was chosen "+ count5+" times");
		System.out.println("Positive changes"+ positive);
		System.out.println("Negative changes"+ negative);
		System.out.println("No change"+ duplicate);
	}
}
