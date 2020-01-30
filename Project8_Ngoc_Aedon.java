import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Project8_Ngoc_Aedon 
{

	public static void main(String[] args) throws FileNotFoundException
	{
		String data[] = enterData("SampleData.txt");
		changeToLowerCase(data);
		String most = findMostCommonFood(data);
		System.out.println(most);
	}
	
	public static String[] enterData(String fileName) throws FileNotFoundException
	{
		Scanner scnr = new Scanner(new File(fileName));
		int i = 0;
		while (scnr.hasNext()) {
			scnr.nextLine();
			i++;
		}
		String[] data = new String[i];
		Scanner two = new Scanner(new File(fileName));
		for (int j = 0; j<i; ++j) {
			data[j] = two.nextLine();
		}
		
		return data;
	}
	
	public static void changeToLowerCase(String[] data)
	{
		for (int n = 0; n<data.length; ++n) {
			data[n] = data[n].toLowerCase();
		}
	}
	
	public static String findMostCommonFood(String[] data)
	{
		Arrays.sort(data);
		int count = 0;
		int max = 0;
		String temp = "";
		String most = "";
		for(int m = 0; m <data.length;++m) {
			if(!data[m].equals(temp)) {
				temp = data[m];
				count = 1;
			}
			else {
				++count;
			}
			if (count > max) {
				max = count;
				most = temp;
			}
		}
		
		return most;
	}
}
