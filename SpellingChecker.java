import java.util.Arrays;

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
/** This program is a word by word spelling checker.  It relies on two dictionaries: a global
 * dictionary and a personal dictionary that is initially empty.  The program reads the file
 * names for these dictionaries from the command line. 
 * @author Deborah A. Trytten
 *
 */

public class SpellingChecker 
{
	
	/** The personal dictionary may have only this many elements.
	 * 
	 */
	public static final int SIZE = 100;
	

	/** The program reads the global and personal dictionaries from files into arrays.
	 * The contents of the arrays are then searched (using binary search) to find out
	 * whether words are spelled correctly or not.  If a word is not found in either dictionary
	 * the user is asked whether the word should be added to the personal dictionary. At the
	 * end of the program, the personal dictionary is written out to a file.
	 * @param args The first command line argument is the global dictionary, one word to a line,
	 * all words in lower case.  The second command line argument is the personal dictionary. 
	 * @throws FileNotFoundException If either of the dictionaries are not found in the Project
	 * directory of eclipse.
	 */

	public static void main(String[] args) throws FileNotFoundException
	{
		args= new String[] {"Dictionary.txt","Personal.txt"};

		// This kind of guard is always a good idea, in case people misunderstand command
		// line arguments
		if (args.length != 2)
		{
			System.out.println("Please enter the name of the global and personal dictionaries"
						+ " at the command line");
			System.exit(0); // failure
		}
		
		// The size of the global dictionary is fixed
		ArrayList<String> globalDictionary = readDictionary(args[0]);
		
		// The personal dictionary has to be allocated extra size and the size must
		// be tracked
		ArrayList<String> personalDictionary = readDictionary(args[1]);
		
		//int personalDictSize = readDictionaryFixedSize(personalDictionary, args[1]);
		int personalDictSize= personalDictionary.size();
		// The size of the personal dictionary may change during execution
		processInput(globalDictionary, personalDictionary);
		
		// Write the personal dictionary out to the file it came from
		writePersonalDictionary(personalDictionary,  args[1]);
		
	}

	/** Repeatedly allow the user to enter a word.  The word will be sought in the
	 * global and local dictionaries.  If it is not found, the user will be asked if
	 * it should be added to the local dictionary.  If the user wishes to add it, it 
	 * will be inserted in the local dictionary.
	 * @param global The global dictionary of words.
	 * @param personal The personal (local) dictionary of words.
	 * @param personalSize The number of active words in the personal (local) dictionary at the start
	 * of the method.
	 * @return The number of active words in the personal (local) dictionary
	 */
	public static void processInput(ArrayList<String> global, ArrayList<String> personal)
	{
		Scanner keyboard = new Scanner(System.in);
		
		String answer;
		
		// user input will terminate this loop
		while (true)
		{
			// this means we can't spell check quit--but that's OK.
			System.out.println("Enter a word or QUIT to stop:");
			String word = keyboard.next();
			word = word.toLowerCase(); // the dictionary is in lower case
			
			// Get out of this method if the user wants to quit
			if (word.equalsIgnoreCase("Quit"))
				return;
			
			// Search the global dictionary
			Collections.sort(global);
			Collections.sort(personal);
			if (Collections.binarySearch(global, word) >= 0)
			{
				System.out.println("That word is spelled correctly");
			}
			// Search the personal dictionary
			else if (Collections.binarySearch(personal, word) < 0)
			{
				System.out.println("That word is not spelled correctly");
				System.out.println("Would you like to add it to your personal dictionary Yes/No");
				answer = keyboard.next();
				if (answer.equalsIgnoreCase("Yes") && personal.size() < SIZE-1)
				{
					personal.add(word);
//					++personalSize;
					Collections.sort(personal);
				}
			} // word not found in either dictionary
			else // This logic looks odd, but it was done this way to avoid calling
				// either search twice
			{
				System.out.println("That word is spelled correctly"); // found in personal dictionary
			}
			
		} // end while
	
	}
	
	/** Read the dictionary file.
	 * 
	 * @param fileName The name of the file.
	 * @return  An array containing each line of the file. The array size comes from the
	 * number of lines in the file.
	 * @throws FileNotFoundException If the file is not found in the Project directory as expected.
	 */
	public static ArrayList<String> readDictionary(String fileName) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File(fileName));
		
		// find the length of the dictionary by reading the file
//		int count = 0;
//		while (file.hasNextLine())
//		{
//			++count;
//			file.nextLine();
//		}
//		file.close();
		
		// Now read the file and fill the array
		ArrayList<String> result = new ArrayList<String>();
//		file = new Scanner(new File(fileName));
//		int index = 0;
//		while (index < count)
		while(file.hasNextLine())
		{
			result.add(file.nextLine());
//			++index;
		}
		file.close();
		return result;
		
	}
	
	/** Read the dictionary into an array of fixed size.
	 * 
	 * @param array The array of fixed size, allocated before the method.
	 * @param fileName The name of the file containing the data.
	 * @return The number of lines in the file, and hence the size of the active array.
	 * @throws FileNotFoundException If the file is not found in the Project directory.
	 */
//	public static int readDictionaryFixedSize(ArrayList<String> array, String fileName) throws FileNotFoundException
//	{
//		Scanner file = new Scanner(new File(fileName));

		// Read in the file contents until you run out of File or array
//		int index = 0;
//		while (index < SIZE && file.hasNextLine())
//		{
//			array.add(file.nextLine());
//			++index;
//		}
//		file.close();
		
//		return array.size();
//		return index;

//	}
	
	/** Write the personal dictionary out to a file.
	 * 
	 * @param personalDictionary The array containing the personal dictionary.
	 * @param size The number of elements in the array that are active.
	 * @param fileName The name of the file.
	 * @throws FileNotFoundException If the file cannot be saved in the Project directory for 
	 * any reason.
	 */
	public static void writePersonalDictionary(ArrayList<String> personalDictionary,  String fileName)
		throws FileNotFoundException
	{
		PrintWriter pw = new PrintWriter(new File(fileName));
		
		for(int i=0; i<personalDictionary.size(); ++i)
		{
			pw.write(personalDictionary.get(i) + "\n");			
		}
		
		pw.close();
	}
}
