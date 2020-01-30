import java.util.Scanner;
import java.lang.Math;

public class Project3_Ngoc_Hoang {
	public static void main (String[] args)
	{
		 Scanner input= new Scanner(System.in);
		 
		//declare integer anting point
		 
		 System.out.println("Enter the name of first type of yarn");
		 String yardtype = input.nextLine();
		 
		 System.out.println("Enter the number of yards per ball of yarn");
		 int yardnumberperball = input.nextInt();
		 input.nextLine();
		 
		 if (yardnumberperball <0) 
		 {
		 System.out.println("The number of yarn must be positive, please reenter");
		  yardnumberperball = input.nextInt();
		 input.nextLine();
		 }
		 
		 System.out.println("Enter the number of balls needed");
		 int ballnumber = input.nextInt();
		 input.nextLine();
		 
		 if (ballnumber <0) 
		 {
		 System.out.println("The number of ball must be postive, please reenter");
		 ballnumber = input.nextInt();
		 input.nextLine();
		 }
		 
		 double result= yardnumberperball* ballnumber;
		 System.out.println("Yards of yarn to complete in project"+ result);
		 
		 System.out.println("Enter the name of subtituted yarn");
		 String yardtype1 = input.nextLine();
		 
		 System.out.println("Enter the number of yards per ball of yarn");
		 int yardnumberperball1 = input.nextInt();
		 input.nextLine();
		 
		 if (yardnumberperball1 <0) 
		 {
		 System.out.println("The number of yarn must be positive, please reenter");
		 yardnumberperball1 = input.nextInt();
		 input.nextLine();
		 }
		 
		 System.out.println(result);
		 System.out.println(yardnumberperball1);
		 int balls1 = (int)Math.ceil(result/yardnumberperball1);
		 
		 System.out.println("You should purchase "+ balls1 + " balls of "+ yardtype1 + " instead of "+ ballnumber +" of "+ yardtype);
	
		 input.close();
	}

}
