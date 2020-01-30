import java.util.Scanner;
import java.lang.Math;

public class Project4 {
	public static void main(String[] args)
	{
		Scanner input= new Scanner(System.in);
		int sum=0;
		System.out.println("Answer yes or no to the following questions");
		System.out.println("I am losing my sense of humor.");
		String answer1= input.nextLine();
		if(answer1.equalsIgnoreCase("Yes"))
		{
			
			sum=sum+1;
		}
		else
		{
			sum=sum;
		}
		
		System.out.println("I find it more and more difficult to see people socially");
		String answer2= input.nextLine();
		if(answer2.equalsIgnoreCase("Yes"))
		{
			
			sum=sum+1;
		}
		else
		{
			sum=sum;
		}
		
		System.out.println("I feel tired most of the time.");
		String answer3= input.nextLine();
		
		if(answer3.equalsIgnoreCase("Yes"))
		{
			sum=sum+1;
		}
		else
		{
			sum=sum;
		}
		
		if (sum==3)
		{
			System.out.println("You're probably stressed out");
		}
		else if(sum==2)
		{
			System.out.println("You're possibly stressed out");
		}
		else if(sum==1)
		{
			System.out.println("You're beginning to stress out");
		}
		else if(sum==0)
		{
			System.out.println("You're more exhausted than stress out");
		}
	}
}
